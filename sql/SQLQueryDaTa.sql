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
delete from ThuongHieu
insert into ThuongHieu
values (default, N'Thiên Long'),
(default, N'Campus'),
(default, N'Ánh Dương'),
(default, N'OEM'),
(default, N'Hồng Hà'),
(default, N'OEM'),
(default, N'Deli'),
(default, N'Morning Glory'),
(default, N'FAHASA'),
(default, N'Pilot'),
(default, N'Milan'),
(default, N'Pentel'),
(default, N'Plus'),
(default, N'Stacom'),
(default, N'Elephant')
go 
delete from MauSac
select * from MauSac
insert into MauSac
values (default, N'Xanh Dương'), (default, N'Xanh Lá'), (default, N'Đỏ'), (default, N'Tím'), (default, N'Vàng'),(default, N'Trắng'),(default, N'Đen'), (default, N'Trắng')
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

delete from SanPham
--them sach
insert into SanPham (maSP,tenSP,namXB_SX,soLuong,donGia,donVi,VAT,soTrang,nguoiDich,tuoiGioiHan,moTa,hinhAnh,maLoai,maNCC,maNXB,maTG,maLB,maCDH,trangThai)
values 
	(dbo.autoIdSP('SVH00001'),N'Những Đêm Không Ngủ Những Ngày Chậm Trôi',2021,100,60000,N'Quyển',10,192,null,null,N'“Những đêm không ngủ, những ngày chậm trôi” đại diện cho một hành tinh mới - nơi nỗi đau tinh thần được đưa ra ánh sáng và chữa lành.','SVH00001.jpg','SVH00001','NCC00001','NXB00001','TG00001','LB00001',null,0)
go
--them van phong pham
insert into SanPham (maSP,tenSP,soLuong,donGia,donVi,VAT,xuatXu,chatLieu, moTa,hinhAnh,maLoai,maNCC,maTH,maMau,trangThai)
values 
	(dbo.autoIdSP('VPP00001'),N'Bút Bi Thiên Long TL-061', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế đơn giản, toàn bộ thân bút làm từ nhựa trong pha màu nhạt, nhìn được phần ruột bút bên trong','D:\workspace\HeThongBanSach\img\VPP00001','VPP00001', 'NCC00002',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00002'),N'Bút Bi 0.5 mm Thiên Long TL-061', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế đơn giản, toàn bộ thân bút làm từ nhựa trong pha màu nhạt, nhìn được phần ruột bút bên trong','D:\workspace\HeThongBanSach\img\VPP00002','VPP00001', 'NCC00002',  'TH00002', 'MS00007', 0),
	(dbo.autoIdSP('VPP00003'),N'Bút Bi 0.5 mm Treeden', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế hiện đại, kết hợp hài hòa giữa phần thân dưới bằng nhựa trong nhỏ và thon dài với phần giắt bút màu nhựa trắng đục khỏe khoắn','D:\workspace\HeThongBanSach\img\VPP00003','VPP00001', 'NCC00002',  'TH00003', 'MS00001', 0),
	(dbo.autoIdSP('VPP00004'),N'Bút Bi 0.5 mm Thiên Long TL-027', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế tối giản, nhưng tinh tế và ấn tượng. Toàn bộ thân bút làm từ nhựa trong, phối hợp hoàn hảo với màu ruột bút bên trong.','D:\workspace\HeThongBanSach\img\VPP00004','VPP00001', 'NCC00002',  'TH00004', 'MS00003', 0),
	(dbo.autoIdSP('VPP00005'),N'Bút Xóa 12 ml - Thiên Long CP-02', 100,26000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Mực xóa nhanh khô, che phủ tốt, không độc hại và an tòan với tầng ozone. Đầu bút bằng kim lọai có lò xo đàn hồi tốt , bền khi sử dụng.','D:\workspace\HeThongBanSach\img\VPP00005','VPP00001', 'NCC00002',  'TH00005', 'MS00001', 0),
	(dbo.autoIdSP('VPP00006'),N'Bút Gel-08 - Đỏ', 100,8000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thân và bút bằng nhựa trong, tảm có đệm mềm (grip) giúp cầm êm tay và giảm trơn trợt khi viết.','D:\workspace\HeThongBanSach\img\VPP00006','VPP00001', 'NCC00003',  'TH00001', 'MS00003', 0),
	(dbo.autoIdSP('VPP00007'),N'Bút Gel Thiên Long Gel-08 Sunbeam', 100,8000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thân và bút bằng nhựa trong, tảm có đệm mềm (grip) giúp cầm êm tay và giảm trơn trợt khi viết.','D:\workspace\HeThongBanSach\img\VPP00007','VPP00001', 'NCC00004',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00008'),N'Bút Lông Bảng 2.0 mm - Artline EK-517-GR', 100,32000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Mực đậm, lượng mực cực kỳ nhiều, thêm mực dễ dàng sau khi viết hết. Dễ viết dễ xóa. Ngòi viết ra mực đều màu, êm, khi xóa không làm xước bề mặt bảng.','D:\workspace\HeThongBanSach\img\VPP00008','VPP00001', 'NCC00005',  'TH00006', 'MS00002', 0),
	(dbo.autoIdSP('VPP00009'),N'Bút Chì Gỗ Graphite 4B', 100,7000,N'Cây',10,N'Việt Nam',N'Gỗ',N'Thân bút tam giác độc đáo, không những giúp người sử dụng cầm bút chắc tay mà còn ngăn không cho bút lăn khi để trên bàn, tránh rơi rớt.','D:\workspace\HeThongBanSach\img\VPP00009','VPP00001', 'NCC00006',  'TH00007', 'MS00007', 0),
	(dbo.autoIdSP('VPP00010'),N'Thước M-Tech Slim 20 cm', 100,7000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thước kẻ được sử dụng nhiều trong học tập, cơ khí, vẽ các bảng kĩ thuật, xây dựng, vẽ tranh...','D:\workspace\HeThongBanSach\img\VPP00010','VPP00003', 'NCC00007',  'TH00008', 'MS00008', 0),
	(dbo.autoIdSP('VPP00011'),N'Thước M-Tech Slim 30 cm', 100,10000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thước kẻ được sử dụng nhiều trong học tập, cơ khí, vẽ các bảng kĩ thuật, xây dựng, vẽ tranh...','D:\workspace\HeThongBanSach\img\VPP00011','VPP00003', 'NCC00008',  'TH00009', 'MS00008', 0),
	(dbo.autoIdSP('VPP00012'),N'Bộ Thước 20cm', 100,12000,N'Bộ',10,N'Ấn Độ',N'Nhựa',N'Sản phẩm bao gồm 1 cây thước 20cm, bộ thước eke và thước đo góc 45o và 60o.','D:\workspace\HeThongBanSach\img\VPP00012','VPP00003', 'NCC00002',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00013'),N'Gôm Đen E-011', 100,4000,N'Cục',10,N'Việt Nam',N'Nhựa',N'Gôm Đen E-011 với độ bền dẻo cao có khả năng tẩy sạch các vết chì đen mà không gây rách giấy, không làm bẩn, lem trên giấy trắng','D:\workspace\HeThongBanSach\img\VPP00013','VPP00003', 'NCC00009',  'TH00010', 'MS00007', 0),
	(dbo.autoIdSP('VPP00014'),N'Vỉ 2 Gôm Thiên Long E-05', 100,9000,N'Vỉ',10,N'Việt Nam',N'Nhựa',N'Gôm với độ bền dẻo cao có khả năng tẩy sạch các vết chì đen mà không gây rách giấy, không làm bẩn, lem trên giấy trắng','D:\workspace\HeThongBanSach\img\VPP00014','VPP00003', 'NCC00010',  'TH00011', 'MS00008', 0),
	(dbo.autoIdSP('VPP00015'),N'Chuốt Chì', 100,3000,N'Cái',10,N'Việt Nam',N'Nhựa',N'Chuốt chì với thiết kế dễ sử dụng, chuốt được nhiều loại bút chì có đường kính tiêu chuẩn như bút chì đen, bút chì màu.','D:\workspace\HeThongBanSach\img\VPP00015','VPP00003', 'NCC00011',  'TH00012', 'MS00003', 0),
	(dbo.autoIdSP('VPP00016'),N'Tập Sinh Viên 4 Ly Ngang 200 Trang', 100,17000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','D:\workspace\HeThongBanSach\img\VPP00016','VPP00002', 'NCC00012',  'TH00013', 'MS00008', 0),
	(dbo.autoIdSP('VPP00017'),N'Tập Học Sinh Baby Dinosaur B5 48 Trang', 100,11000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','D:\workspace\HeThongBanSach\img\VPP00017','VPP00002', 'NCC00013',  'TH00014', 'MS00008', 0),
	(dbo.autoIdSP('VPP00018'),N'Vở Freely Life - B5 Kẻ Ngang 120 Trang', 100,17000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','D:\workspace\HeThongBanSach\img\VPP00018','VPP00002', 'NCC00014',  'TH00015', 'MS00008', 0),
	(dbo.autoIdSP('VPP00019'),N'Vở Dancing Letters - B5 200 Trang', 100,34000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','D:\workspace\HeThongBanSach\img\VPP00019','VPP00002', 'NCC00015',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00020'),N'Giấy Kiểm Tra Học Sinh', 100,4000,N'Tờ',10,N'Việt Nam',N'Giấy',N'Dòng kẻ rõ nét, giấy viết không nhòe, không bám bụi.','D:\workspace\HeThongBanSach\img\VPP00020','VPP00002', 'NCC00016',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00021'),N'Giấy Kiểm Tra B5 Có Chấm', 100,21000,N'Xấp',10,N'Việt Nam',N'Giấy',N'Dòng kẻ rõ nét, giấy viết không nhòe, không bám bụi.','D:\workspace\HeThongBanSach\img\VPP00021','VPP00002', 'NCC00017',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00022'),N'Bấm Kim', 100,21000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Trong văn phòng, bấm kim là vật dụng không thể thiếu khi bạn muốn liên kết, kẹp các tờ giấy tài liệu quan trọng lại với nhau','D:\workspace\HeThongBanSach\img\VPP00022','VPP00004', 'NCC00018',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00023'),N'Bấm Kim', 100,21000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Trong văn phòng, bấm kim là vật dụng không thể thiếu khi bạn muốn liên kết, kẹp các tờ giấy tài liệu quan trọng lại với nhau','D:\workspace\HeThongBanSach\img\VPP00023','VPP00004', 'NCC00019',  'TH00001', 'MS00005', 0),
	(dbo.autoIdSP('VPP00024'),N'Bìa Trình Kí 1 Mặt ', 100,36000,N'Tờ',10,N'Việt Nam',N'Nhựa',N'Được làm từ chất liệu nhựa PS cao cấp ','D:\workspace\HeThongBanSach\img\VPP00024','VPP00004', 'NCC00020',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00025'),N'Bìa Trình Ký Đôi', 100,54000,N'Tờ',10,N'Việt Nam',N'Nhựa',N'Được làm từ chất liệu nhựa PS cao cấp ','D:\workspace\HeThongBanSach\img\VPP00025','VPP00004', 'NCC00021',  'TH00001', 'MS00003', 0),
	(dbo.autoIdSP('VPP00026'),N'Kim Bấm', 100,3000,N'Hôp',10,N'Việt Nam',N'Kim Loại',N'Được làm từ thép không gỉ khá cứng cáp và chắc chắn, không bị bung rời khi sử dụng cũng như đảm bảo độ bền cao.','D:\workspace\HeThongBanSach\img\VPP00026','VPP00004', 'NCC00022',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00027'),N'Kim Bấm', 100,10000,N'Hôp',10,N'Việt Nam',N'Kim Loại',N'Được làm từ thép không gỉ khá cứng cáp và chắc chắn, không bị bung rời khi sử dụng cũng như đảm bảo độ bền cao.','D:\workspace\HeThongBanSach\img\VPP00027','VPP00004', 'NCC00023',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00028'),N'Kẹp Giấy ', 100,4000,N'Cái',10,N'Việt Nam',N'Kim Loại',N'Đầu tam giác, đầu tròn được sản xuất từ kim loại chất lượng cao, được phủ lớp Niken chống gỉ.','D:\workspace\HeThongBanSach\img\VPP00028','VPP00004', 'NCC00024',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00029'),N'Hộp Kẹp Bướm', 100,25000,N'Hộp',10,N'Việt Nam',N'Kim Loại',N'Đầu tam giác, đầu tròn được sản xuất từ kim loại chất lượng cao, được phủ lớp Niken chống gỉ.','D:\workspace\HeThongBanSach\img\VPP00029','VPP00004', 'NCC00025',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00030'),N'Hộp 12 Bút Sáp Màu', 100,25000,N'Hộp',10,N'Việt Nam',N'Sáp',N'Bút sáp màu được sản xuất với thân bằng sáp mềm với thiết kế dễ cầm nắm đối với bàn tay nhỏ bé của các nghệ sĩ trẻ.','D:\workspace\HeThongBanSach\img\VPP00030','VPP00005', 'NCC00026',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00031'),N'Hộp 8 Bút Sáp Màu', 100,13000,N'Hộp',10,N'Việt Nam',N'Sáp',N'Bút sáp màu được sản xuất với thân bằng sáp mềm với thiết kế dễ cầm nắm đối với bàn tay nhỏ bé của các nghệ sĩ trẻ.','D:\workspace\HeThongBanSach\img\VPP00031','VPP00005', 'NCC00027',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00032'),N'Bút Lông Màu Nước', 100,52000,N'Cây',10,N'Việt Nam',N'Sáp',N'Bút sáp màu được sản xuất với thân bằng sáp mềm với thiết kế dễ cầm nắm đối với bàn tay nhỏ bé của các nghệ sĩ trẻ.','D:\workspace\HeThongBanSach\img\VPP00032','VPP00005', 'NCC00003',  'TH00001', 'MS00008', 0)
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
