use BanSach
go

select * from NhaCungCap
insert into NhaCungCap
values
	(default,N'Cty VPP Hồng Hà',N'Trần Quốc Toàn','0123456789',N'số 25 Lý Thường Kiệt - HN',0),
	(default,N'AZ Việt Nam',N'Trần Quốc Toàn','0964484633',N'Số 50 - Đường 5 - Khu tập thể F361 - phố An Dương - P. Yên Phụ - Q.Tây Hồ - HN',1),
	(default,N'Thiên Long Hoàn Cầu',N'Trương Văn Tuấn','0944742935', N'Tầng 10 - Sofic Tower - Số 10 Đường Mai Chí Thọ - Phường Thủ Thiêm - TP.Thủ Đức -TP.HCM - VN', 0),
	(default,N'CamPus',N'Trương Văn Tuấn','0944742935', N'Số 243 Dũng Sĩ Thanh Khê - Q.Thanh Khê - Đà Nẵng - VN', 0)
go 
select * from ThuongHieu
insert into ThuongHieu
values (default, N'OEM')
go 
select * from MauSac
insert into MauSac
values (default, N'Xanh Dương'), (default, N'Xanh Lá'), (default, N'Đỏ'), (default, N'Tím'), (default, N'Vàng'),(default, N'Trắng'),(default, N'Đen')
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
	(dbo.autoIdLSP('SGK'),N'Sách Giáo Khoa'),
	(dbo.autoIdLSP('SVH'),N'Sách Văn Học'),
	(dbo.autoIdLSP('STN'),N'Sách Thiếu Nhi'),
	(dbo.autoIdLSP('SKT'),N'Sách Kinh Tế'),
	(dbo.autoIdLSP('SNN'),N'Sách Ngoại Ngữ'),
	(dbo.autoIdLSP('VPP'),N'Bút - Viết'),
	(dbo.autoIdLSP('VPP'),N'Sản Phẩm Giấy'),
	(dbo.autoIdLSP('VPP'),N'Dụng Cụ Học Sinh'),
	(dbo.autoIdLSP('VPP'),N'Dụng Cụ Văn Phòng'),
	(dbo.autoIdLSP('VPP'),N'Dụng Cụ Vẽ'),
	(dbo.autoIdLSP('VPP'),N'Sản Phẩm Khác');
go
select * from SanPham
--them sach
insert into SanPham (maSP,tenSP,namXB_SX,soLuong,donGia,donVi,VAT,soTrang,nguoiDich,tuoiGioiHan,moTa,hinhAnh,maLoai,maNCC,maNXB,maTG,maLB,maCDH,trangThai)
values 
	(dbo.autoIdSP('SVH00001'),N'Những Đêm Không Ngủ Những Ngày Chậm Trôi',2021,100,60000,N'Quyển',10,192,null,null,N'“Những đêm không ngủ, những ngày chậm trôi” đại diện cho một hành tinh mới - nơi nỗi đau tinh thần được đưa ra ánh sáng và chữa lành.','SVH00001.jpg','SVH00001','NCC00001','NXB00001','TG00001','LB00001',null,0)
go
--them van phong pham
insert into SanPham (maSP,tenSP,soLuong,donGia,donVi,VAT,xuatXu,chatLieu, moTa,hinhAnh,maLoai,maNCC,maTH,maMau,trangThai)
values 
	(dbo.autoIdSP('VPP00020'),N'Test5', 1000,7000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế đơn giản, toàn bộ thân bút làm từ nhựa trong pha màu nhạt, nhìn được phần ruột bút bên trong','blttl061.jpg','VPP00003', 'NCC00002',  'TH00001', 'MS00001', 0)
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
	(default,N'Nguyễn Nhật Sang', '1998/01/25','790168265868',N'448/3, tỉnh lộ 8, ấp Tây, Tân An Hội, Củ Chi, Tp Hồ Chí Minh','0396979388',1,0,'CV00002'),
	(default,N'Trương Văn Tuấn', '1998/01/25','790168265868',N'448/3, tỉnh lộ 8, ấp Tây, Tân An Hội, Củ Chi, Tp Hồ Chí Minh','0396979388',1,0,'CV00001')
go
select * from TaiKhoan
insert into TaiKhoan
values ('NV00001','123','NV00001')
go
select * from KhachHang
insert into KhachHang
values
	(default,N'Lương Viết Thanh','2002/07/27',N'448/3, tỉnh lộ 8, ấp Tây, Tân An Hội, Củ Chi, Tp Hồ Chí Minh','0396979388',1,1)
go
select * from CapDoHoc
insert into CapDoHoc
values
	(default,N'Cấp 1',1),
	(default,N'Cấp 1',2),
	(default,N'Cấp 1',3),
	(default,N'Cấp 1',4),
	(default,N'Cấp 1',5),
	(default,N'Cấp 2',6),
	(default,N'Cấp 2',7),
	(default,N'Cấp 2',8),
	(default,N'Cấp 2',9),
	(default,N'Cấp 3',10),
	(default,N'Cấp 3',11),
	(default,N'Cấp 3',12)
go
/* Thử dữ liệu*/

delete from KhachHang
go
select maSP,tenSP,hinhAnh,donGia, donVi, soLuong,maNCC, VAT from SanPham
where tenSP = N'những Đêm Không Ngủ Những Ngày Chậm Trôi' or maSP = 'SVH00001'
go
select dbo.autoIdHD()
go
select maNV,hoTen,maCV from NhanVien where maNV = 'NV00001'
go
select maKH,hoTen,diaChi,sdt from KhachHang where sdt = '0396979388'