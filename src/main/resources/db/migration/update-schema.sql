ALTER TABLE web_ban_giay.huyen
DROP
FOREIGN KEY fk_tinh;

ALTER TABLE web_ban_giay.gio_hang_yeu_thich
    ADD CONSTRAINT uc_gio_hang_yeu_thich_id_khach_hang UNIQUE (id_khach_hang);

DROP TABLE web_ban_giay.huyen;

DROP TABLE web_ban_giay.tinh;

ALTER TABLE web_ban_giay.cua_hang
DROP
COLUMN id_huyen;

ALTER TABLE web_ban_giay.`role`
DROP
COLUMN status;

ALTER TABLE web_ban_giay.gio_hang_yeu_thich
DROP
COLUMN yeu_thich;

ALTER TABLE web_ban_giay.danh_muc_san_pham_bac2
    MODIFY id_dm_b1 INT NULL;

ALTER TABLE web_ban_giay.chi_tiet_hoa_don
    MODIFY id_hd INT NULL;

ALTER TABLE web_ban_giay.gio_hang_yeu_thich
    MODIFY id_khach_hang INT NULL;

ALTER TABLE web_ban_giay.gio_hang_yeu_thich
    MODIFY id_san_pham INT NULL;

ALTER TABLE web_ban_giay.chi_tiet_hoa_don
    MODIFY id_sp INT NULL;

ALTER TABLE web_ban_giay.`role`
    MODIFY mota VARCHAR (45) NOT NULL;

ALTER TABLE web_ban_giay.`role`
    MODIFY name VARCHAR (45) NOT NULL;

ALTER TABLE web_ban_giay.khach_hang
DROP
COLUMN ngay_sinh;

ALTER TABLE web_ban_giay.khach_hang
    ADD ngay_sinh datetime NULL;

ALTER TABLE web_ban_giay.tai_khoan
    MODIFY phone VARCHAR (100);

ALTER TABLE web_ban_giay.chi_tiet_hoa_don
    MODIFY size VARCHAR (255);

ALTER TABLE web_ban_giay.chi_tiet_hoa_don
    MODIFY so_luong INT NULL;

ALTER TABLE web_ban_giay.khach_hang
    MODIFY status BIT (1) NOT NULL;