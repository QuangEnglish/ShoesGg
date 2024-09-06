package com.devpro.JavaWeb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.devpro.JavaWeb.conf.PaypalPaymentIntent;
import com.devpro.JavaWeb.conf.PaypalPaymentMethod;
import com.devpro.JavaWeb.controller.customer.CartController;
import com.devpro.JavaWeb.model.KhachHang;
import com.devpro.JavaWeb.services.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

    @Autowired
    PaypalService service;
    
    @Autowired
    CartController cartController;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";

    @RequestMapping(value="/pay", method = RequestMethod.GET)
    public String payment(final Model model,
			HttpServletRequest request,
			HttpServletResponse response
			) {
    	Double giaTien = Double.parseDouble(request.getParameter("giaTien"));
    	giaTien = giaTien / 24000;
        try {
            Payment payment = service.createPayment(giaTien, "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "Mô tả", "http://localhost:8081/" + CANCEL_URL,
                    "http://localhost:8081/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "Không thành công";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @RequestMapping(value = SUCCESS_URL, method = RequestMethod.GET)
    public String successPay(
    		final Model model,
			HttpServletRequest request,
			HttpServletResponse response
//    		@RequestParam("paymentId") String paymentId,
//    		@RequestParam("PayerID") String payerId
    		) {
        try {
        	String payerId = request.getParameter("PayerID");
        	String paymentId = request.getParameter("paymentId");
            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
            	HttpSession httpSession = request.getSession();
            	KhachHang khachHang = (KhachHang) httpSession.getAttribute("khachHang");
            	cartController.savePayment(khachHang, request);
                return "redirect:/thanh-toan?ispayment=true";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}