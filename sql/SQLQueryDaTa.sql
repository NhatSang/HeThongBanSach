use BanSach
go
select * from NhaCungCap
insert into NhaCungCap
values (default,N'AZ Việt Nam',N'Trần Quốc Toàn','0964484633',N'Số 50 - Đường 5 - Khu tập thể F361 - phố An Dương - P. Yên Phụ - Q.Tây Hồ - HN')
go
select * from NhaXuatBan
insert into NhaXuatBan
values (default,N'NXB Văn Học')
go
select * from TacGia
insert into TacGia
values (default, N'A Crazy Mind')
go
select * from LoaiBia
insert into LoaiBia
values (default,N'Bìa Mềm'),
		(default,N'Bìa Cứng');
go
select * from LoaiSanPham
insert into LoaiSanPham
values
	(default,N'Sách Giáo Khoa'),
	(default,N'Sách Văn Học'),
	(default,N'Sách Thiếu Nhi'),
	(default,N'Sách Kinh Tế'),
	(default,N'Sách Ngoại Ngữ'),
	(default,N'Bút - Viết'),
	(default,N'Sản Phẩm Giấy'),
	(default,N'Dụng Cụ Học Sinh'),
	(default,N'Dụng Cụ Văn Phòng'),
	(default,N'Dụng Cụ Vẽ'),
	(default,N'Sản Phẩm Khác');
go
select * from SanPham
insert into SanPham (maSP,tenSP,namXB_SX,soLuong,donGia,donVi,VAT,soTrang,nguoiDich,tuoiGioiHan,moTa,hinhAnh,maLoai,maNCC,maNXB,maTG,maLB,maCDH)
values (dbo.autoIdSP(2),N'Những Đêm Không Ngủ Những Ngày Chậm Trôi',2021,100,60000,N'Quyển',10,192,null,null,N'“Những đêm không ngủ, những ngày chậm trôi” đại diện cho một hành tinh mới - nơi nỗi đau tinh thần được đưa ra ánh sáng và chữa lành.','SVH00001.jpg','LSP00002','NCC00001','NXB00001','TG00001','LB00001',null)
go
select * from ChucVu
insert into ChucVu
values 
	(default,N'Nhân Viên Bán Hàng'),
	(default,N'Nhân Viên Quản Lý');
go
select * from NhanVien
insert into NhanVien
values
	(default,N'Nguyễn Nhật Sang', '1998/01/25','790168265868',N'448/3, tỉnh lộ 8, ấp Tây, Tân An Hội, Củ Chi, Tp Hồ Chí Minh','0396979388',1,'CV00002'),
	(default,N'Trương Văn Tuấn', '1998/01/25','790168265868',N'448/3, tỉnh lộ 8, ấp Tây, Tân An Hội, Củ Chi, Tp Hồ Chí Minh','0396979388',1,'CV00001')
go
select * from TaiKhoan
insert into TaiKhoan
values ('NV00002','123','NV00002')
go
select * from KhachHang
insert into KhachHang
values
	(default,N'Lương Viết Thanh','2002/07/27',N'448/3, tỉnh lộ 8, ấp Tây, Tân An Hội, Củ Chi, Tp Hồ Chí Minh','0396979388',1)
go
/* Thử dữ liệu*/
delete from TaiKhoan
go
select maSP,tenSP,hinhAnh,donGia, donVi, soLuong,maNCC from SanPham
where tenSP = N'những Đêm Không Ngủ Những Ngày Chậm Trôi' or maSP = 'SVH00001'
go
select dbo.autoIdHD()
go
select hoTen,maCV from NhanVien where maNV = 'NV00001'
go
select hoTen,diaChi,sdt from KhachHang where sdt = '0396979388'
select *from TaiKhoan