use BanSach
go

select * from NhaCungCap
insert into NhaCungCap
values
	(default,N'Cty VPP Hồng Hà',N'Trần Quốc Toàn','0123456789',N'số 25 Lý Thường Kiệt - HN',0),
	(default,N'AZ Việt Nam',N'Trần Quốc Toàn','0964484633',N'Số 50 - Đường 5 - Khu tập thể F361 - phố An Dương - P. Yên Phụ - Q.Tây Hồ - HN',0),
	(default,N'Thiên Long Hoàn Cầu',N'Trương Văn Tuấn','0944742935', N'Tầng 10 - Sofic Tower - Số 10 Đường Mai Chí Thọ - Phường Thủ Thiêm - TP.Thủ Đức -TP.HCM - VN', 0),
	(default,N'CamPus',N'Trương Văn Tuấn','0944742935', N'Số 243 Dũng Sĩ Thanh Khê - Q.Thanh Khê - Đà Nẵng - VN', 0),
	(default,N'Sang Hà',N'Hoàng Văn Nhân','0309345786',N'Số 7, Đường T4B, P.Tây Thạnh, Q.Tân Phú,TP.HCM(Khu Công Nghiệp Tân Bình)',0),
	(default,N'Kim Biên Toàn Cầu',N'Nguyễn Văn Tài','0906860038',N'525/46 Tô Hiến Thành , P 14, Q 10, HCM.',0),
	(default,N'An Phát',N'BùiDuy Hưng','087152408',N'47/2C Đường TMT13, Khu phố 2, Phường Trung Mỹ Tây, Quận 12, TPHCM',0),
	(default,N'Hồng Hà',N'Lê Hoàng Hiện','0283752158',N'028. 3756 2158',0),
	(default,N'Vinacom',N'Lê Ngọc Như','0835368668',N'275/39/3 Bạch Đằng, Phường 15, Quận Bình Thạnh, TPHCM',0),
	(default,N'Ánh Sáng',N'Trương Ngọc Nhi','062922400',N'96 Đông Hồ, Phường 8, Quận Tân Bình, TPHCM',0),
	(default,N'An Thiên Phước',N'Trương Văn Nam','0916649029',N'33 đường số 17, Phường Hiệp Bình Chánh, Quận Thủ Đức, TPHCM',0),
	(default,N'An Lộc Việt',N'Hoàng Văn Đạt','0866810845',N'479/37 Phan Văn Trị, Phường 5, Quận Gò Vấp, TPHCM',0),
	(default,N'Tân Tiến',N'Lê Ngọc Hà','0391118358',N'15E Nguyễn Thị Minh Khai, Phường Bến Nghé, Quận 1, TPHCM',0),
	(default,N'Hoàng Hà',N'Nguyễn Văn Sang','0283843239',N'247/13 Độc Lập, Phường Tân Quý, Quận Tân Phú, TPHCM',0),
	(default,N'KHANG MINH',N'Nguyễn Duy Nhất','0944697678',N' 70/16 Hiệp Nhất, Phường 4, Quận Tân Bình, TP. Hồ Chí Minh (TPHCM)',0),
	(default,N'ANH ĐỨC',N'Lê Ngọc Hiền','0983481825',N'490/41 Lê Văn Sỹ, Phường 14, Quận 3, TP Hồ Chí Minh (TPHCM)',0),
	(default,N'HÙNG THUẬN PHÁT',N'Trương Kim Chi','0908150636',N' 104/3 Mai Thị Lựu, Phường Đa Kao, Quận 1, TP Hồ Chí Minh (TPHCM)',0),
	(default,N'THẾ GIA',N'Lê Hoàng Nhật An','0903706471',N'VPP THẾ GIA',0),
	(default,N'KHANG LÊ',N'Trương Nhật Duy','0935508693',N'Số 60A, Đường Tam Đông 21, Xã Thới Tam Thôn, Huyện Hóc Môn, Tp Hồ Chí Minh (TPHCM)',0),
	(default,N'SOVINA',N'Hoàng Phú Quý','0837468168',N' Nhà LK - 08 khu B4 Nam Trung Yên, phố Nguyễn Chánh, Phường Yên Hoà, Quận Cầu Giấy, TP Hà Nội (TPHN)',0),
	(default,N'CÔNG TY TNHH ANGEL TAPE VIỆT NAM',N'Lê Đức Toàn','0903024347',N'179 - 181 Lê Đức Thọ, P. 17, Q. Gò Vấp, TP. Hồ Chí Minh (TPHCM)',0)
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
	(dbo.autoIdSP('VPP00003'),N'Test5', 1000,7000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế đơn giản, toàn bộ thân bút làm từ nhựa trong pha màu nhạt, nhìn được phần ruột bút bên trong','blttl061.jpg','VPP00003', 'NCC00002',  'TH00001', 'MS00001', 0)
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
values ('NV00002','123','NV00002')
go
select * from KhachHang
insert into KhachHang
values
	(default,N'Trần Hưng An','2002/12/20',N'Gò Vấp, TP.HCM','',1,1),
	(default,N'Nguyễn Hoàng	Anh','2002/09/03',N'Bình Thạnh, Tp.HCM','',1,0),
	(default,N'Nguyễn Anh Quỳnh','2002/11/14',N'Quận 1, TP.HCM','0744244179',0,0),
	(default,N'Nguyễn Chí Bảo','2001/02/23',N'Quận 2, TP.HCM','0582897921',1,0),
	(default,N'Nguyễn Duy Bảo','2002/11/12',N'Quân 4, TP.HCM','0515010002',1,0),
	(default,N'Thái Trí	Cường','2001/01/22',N'Củ Chi, TP.HCM','0761950742',1,0),
	(default,N'Võ Minh	Chiến','2002/11/24',N'Gò Vấp, TP.HCM','0880381481',1,0),
	(default,N'Châu Thuần Chương','2002/06/03',N'Quận 3, TP.HCM','0265057490',1,0),
	(default,N'Phan Thanh Thuý','2001/02/02',N'Hóc Môn, TP.HCM','0282377452',0,0),
	(default,N'Bùi Nhựt	Duy','2002/10/10',N'Thủ Đức, TP.HCM','0305343592',1,0),
	(default,N'Huỳnh Văn Duy','2002/02/21',N'Dĩ An, Bình Dương','0542158807',1,0),
	(default,N'Nguyễn Thanh	Nhàn','2002/09/11',N'Quận 10, TP.HCM','0598836671',0,0),
	(default,N'Ngô Tấn Đạt','2002/11/11',N'Quận 11, TP.HCM','0559083433',1,0),
	(default,N'Nguyễn Anh Đức','2002/02/09',N'Quận 8, TP.HCM','0082397188',1,0),
	(default,N'Huỳnh Thị Như','2002/07/07',N'Quận 7, TP.HCM','0848621289',0,0),
	(default,N'Phạm Kiều Mỹ Hậu','2002/02/19',N'Thủ Đức, TP.HCM','0749657001',0,0),
	(default,N'Lê Hoàng	Hiện','2002/04/05',N'Hóc Môn, TP.HCM','0721961770',1,0),
	(default,N'Đặng Phạm Thiên Khải','2001/09/07',N'Quận 1, TP.HCM','0689552681',1,0),
	(default,N'Trần Hoàng Long','2002/01/22',N'Quận 2, TP.HCM','0689552681',1,0),
	(default,N'Huỳnh Văn Minh','2002/12/12',N'Quận 10, TP.HCM','0280145946',1,0),
	(default,N'Nguyễn Cao Anh Minh','2002/03/10',N'Tân Bình, TP.HCM','0734930118',1,0),
	(default,N'Huỳnh Trung	Nghị','2002/07/18',N'Bình Tân, TP.HCM','0650605864',1,0),
	(default,N'Nguyễn Thị Kim Ngọc','2002/09/01',N'Quận 4, TP.HCM','0267382886',0,0),
	(default,N'Nguyễn Gia Nguyên','2002/11/11',N'Gò Vấp, TP.HCM','0049442453',0,0),
	(default,N'Hồ Hữu Nhân','2002/11/22',N'Củ Chi, TP.HCM','0707767354',1,1),
	(default,N'Phạm Quỳnh Như','2002/09/05',N'Tân Bình, TP.HCM','0574303591',0,0),
	(default,N'Nguyễn Thế Phong','2002/09/30',N'Bình Thạnh, TP.HCM','0426361616',1,0),
	(default,N'Nguyễn Trí Phong','2002/10/22',N'Quận 1, TP.HCM','0340127952',1,0),
	(default,N'Bùi Thu Thảo','2002/04/06',N'Quận 4, TP.HCM','0371812161',0,0),
	(default,N'Dương Văn Quy','2002/09/01',N'Tân Bình, TP.HCM','0865502663',1,0),
	(default,N'Nguyễn Nhật Sang','1998/01/05',N'Gò Vấp, TP.HCM','0667789485',1,0),
	(default,N'Võ Thanh	Sang','2000/04/22',N'Quận 1, TP.HCM','0284475692',1,0),
	(default,N'Võ Trọng	Tài','2002/11/05',N'Quận 10, TP.HCM','0205855012',1,0),
	(default,N'Nguyễn Đức Tiến','2002/12/12',N'Dĩ An, Bình Dương','0490269107',1,0),
	(default,N'Trần Văn	Tú','2002/06/07',N'Quận 10, TP.HCM','0795242801',1,0),
	(default,N'Trương Văn Tuấn','2002/10/21',N'Quận 12, TP.HCM','0941436048',1,0),
	(default,N'Lương Viết Thanh','2002/02/02',N'Gò Vấp, TP.HCM','0731858868',1,0),
	(default,N'Trần Thái Thanh','2002/10/11',N'Bình Thạnh, TP.HCM','0355889160',1,0),
	(default,N'Lê Quốc	Thịnh','2002/02/28',N'Hóc Môn, TP.HCM','0707851555',1,0),
	(default,N'Nguyễn Thị Ngọc','2002/12/01',N'Gò Vấp, TP.HCM','0836022809',0,0),
	(default,N'Trần Quốc Trọng','2002/11/02',N'Quận 4, TP.HCM','0542327472',1,0),
	(default,N'Ngô Đình Bảo	Yến','2002/02/22',N'Quận 3, TP.HCM','0522110127',0,0)
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
