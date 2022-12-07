﻿use BanSach
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
select * from MauSac
insert into MauSac
values (default, N'Cam'), (default, N'Xanh Lá'), (default, N'Đỏ'), (default, N'Tím'), (default, N'Vàng'),(default, N'Trắng'),(default, N'Đen')
go
insert into NhaXuatBan
values (default,N'NXB Văn Học'), 
	(default,N'NXB Trẻ'), 
	(default,N'NXB Kim Đồng'), 
	(default,N'NXB Giáo Dục'), 
	(default,N'NXB Văn Học'), 
	(default,N'NXB Tổng Hợp TPHCM')
go
select * from TacGia
insert into TacGia
values (default, N'A Crazy Mind'),
(default, N'Xuân Diệu'),
(default, N'Nguyễn Minh Châu'),
(default, N'Hoài niệm'),
(default, N'Nguyễn Ngọc Tú'),
(default, N'Franz Kafka'),
(default, N'Harper Lee')
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
select * from KhachHang
--them sach
insert into SanPham (maSP,tenSP,namXB_SX,soLuong,donGia,donVi,VAT,soTrang,nguoiDich,tuoiGioiHan,moTa,hinhAnh,maLoai,maNCC,maNXB,maTG,maLB,maCDH,trangThai)
values 

	(dbo.autoIdSP('SVH00003'),N'Bước Chậm Lại Giữa Thế Gian Vội Vã',2018,100,65000,N'Quyển',10,280,N'Nguyễn Việt Tú Anh',null,N'Bước chậm lại giữa thế gian vội vã của Đại đức Hae Min đã liên tục đứng đầu danh sách best-seller của nhiều trang sách trực tuyến uy tín của Hàn Quốc, trở thành cuốn sách chữa lành cho hàng triệu người trẻ luôn tất bật với nhịp sống hiện đại hối hả.','SVH00003.jpg','SVH00001','NCC00002','NXB00001','TG00001','LB00001',null,0),
	(dbo.autoIdSP('SGK00001'),N'Ngữ Văn 10/1',2022,100,25000,N'Quyển',10,124,null,null,N'Ngữ Văn 10/1 (Cánh Diều) (2022)','SGK00001.jpg','SGK00001','NCC00002','NXB00002','TG00002','LB00001','CDH00010',0),
	(dbo.autoIdSP('SGK00002'),N'Ngữ Văn 10/2',2020,100,21000,N'Quyển',10,227,null,null,N'Ngữ Văn 10/2 (Kết Nối Trí Thức) (2022)','SGK00002.jpg','SGK00001','NCC00003','NXB00003','TG00003','LB00001',null,0),
	(dbo.autoIdSP('SKT00001'),N'Cái Đuôi Dài',2016,100,163000,N'Quyển',10,227,NULL,null,N'Với tác phẩm Cái đuôi dài, tác giả đã đưa ra một lộ trình tương lai cho ngành thương mại, một lộ trình có thể làm sáng tỏ băn khoăn của nhiều người – người bán hàng và khách hàng.','SKT00001.jpg','SKT00001','NCC00004','NXB00004','TG00004','LB00001',null,0)

insert into SanPham (maSP,tenSP,soLuong,donGia,donVi,VAT,xuatXu,chatLieu, moTa,hinhAnh,maLoai,maNCC,maTH,maMau,trangThai)
values 	
(dbo.autoIdSP('VPP00001'),N'Bút Bi Thiên Long TL-061', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế đơn giản, toàn bộ thân bút làm từ nhựa trong pha màu nhạt, nhìn được phần ruột bút bên trong','VPP00001.jpg','VPP00001', 'NCC00002',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00002'),N'Bút Bi 0.5 mm Thiên Long TL-061', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế đơn giản, toàn bộ thân bút làm từ nhựa trong pha màu nhạt, nhìn được phần ruột bút bên trong','VPP00002.jpg','VPP00001', 'NCC00002',  'TH00002', 'MS00007', 0),
	(dbo.autoIdSP('VPP00003'),N'Bút Bi 0.5 mm Treeden', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế hiện đại, kết hợp hài hòa giữa phần thân dưới bằng nhựa trong nhỏ và thon dài với phần giắt bút màu nhựa trắng đục khỏe khoắn','VPP00003.jpg','VPP00001', 'NCC00002',  'TH00003', 'MS00001', 0),
	(dbo.autoIdSP('VPP00004'),N'Bút Bi 0.5 mm Thiên Long TL-027', 100,5000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Bút có thiết kế tối giản, nhưng tinh tế và ấn tượng. Toàn bộ thân bút làm từ nhựa trong, phối hợp hoàn hảo với màu ruột bút bên trong.','VPP00004.jpg','VPP00001', 'NCC00002',  'TH00004', 'MS00003', 0),
	(dbo.autoIdSP('VPP00005'),N'Bút Xóa 12 ml - Thiên Long CP-02', 100,26000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Mực xóa nhanh khô, che phủ tốt, không độc hại và an tòan với tầng ozone. Đầu bút bằng kim lọai có lò xo đàn hồi tốt , bền khi sử dụng.','VPP00005.jpg','VPP00001', 'NCC00002',  'TH00005', 'MS00001', 0),
	(dbo.autoIdSP('VPP00006'),N'Bút Gel-08 - Đỏ', 100,8000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thân và bút bằng nhựa trong, tảm có đệm mềm (grip) giúp cầm êm tay và giảm trơn trợt khi viết.','VPP00006.jpg','VPP00001', 'NCC00003',  'TH00001', 'MS00003', 0),
	(dbo.autoIdSP('VPP00007'),N'Bút Gel Thiên Long Gel-08 Sunbeam', 100,8000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thân và bút bằng nhựa trong, tảm có đệm mềm (grip) giúp cầm êm tay và giảm trơn trợt khi viết.','VPP00007.jpg','VPP00001', 'NCC00004',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00008'),N'Bút Lông Bảng 2.0 mm - Artline EK-517-GR', 100,32000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Mực đậm, lượng mực cực kỳ nhiều, thêm mực dễ dàng sau khi viết hết. Dễ viết dễ xóa. Ngòi viết ra mực đều màu, êm, khi xóa không làm xước bề mặt bảng.','VPP00008.jpg','VPP00001', 'NCC00005',  'TH00006', 'MS00002', 0),
	(dbo.autoIdSP('VPP00009'),N'Bút Chì Gỗ Graphite 4B', 100,7000,N'Cây',10,N'Việt Nam',N'Gỗ',N'Thân bút tam giác độc đáo, không những giúp người sử dụng cầm bút chắc tay mà còn ngăn không cho bút lăn khi để trên bàn, tránh rơi rớt.','VPP00009.jpg','VPP00001', 'NCC00006',  'TH00007', 'MS00007', 0),
	(dbo.autoIdSP('VPP00010'),N'Thước M-Tech Slim 20 cm', 100,7000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thước kẻ được sử dụng nhiều trong học tập, cơ khí, vẽ các bảng kĩ thuật, xây dựng, vẽ tranh...','VPP00010.jpg','VPP00003', 'NCC00007',  'TH00008', 'MS00008', 0),
	(dbo.autoIdSP('VPP00011'),N'Thước M-Tech Slim 30 cm', 100,10000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Thước kẻ được sử dụng nhiều trong học tập, cơ khí, vẽ các bảng kĩ thuật, xây dựng, vẽ tranh...','VPP00011.jpg','VPP00003', 'NCC00008',  'TH00009', 'MS00008', 0),
	(dbo.autoIdSP('VPP00012'),N'Bộ Thước 20cm', 100,12000,N'Bộ',10,N'Ấn Độ',N'Nhựa',N'Sản phẩm bao gồm 1 cây thước 20cm, bộ thước eke và thước đo góc 45o và 60o.','VPP00012.jpg','VPP00003', 'NCC00002',  'TH00001', 'MS00008', 0),
	(dbo.autoIdSP('VPP00013'),N'Gôm Đen E-011', 100,4000,N'Cục',10,N'Việt Nam',N'Nhựa',N'Gôm Đen E-011 với độ bền dẻo cao có khả năng tẩy sạch các vết chì đen mà không gây rách giấy, không làm bẩn, lem trên giấy trắng','VPP00013.jpg','VPP00003', 'NCC00009',  'TH00010', 'MS00007', 0),
	(dbo.autoIdSP('VPP00014'),N'Vỉ 2 Gôm Thiên Long E-05', 100,9000,N'Vỉ',10,N'Việt Nam',N'Nhựa',N'Gôm với độ bền dẻo cao có khả năng tẩy sạch các vết chì đen mà không gây rách giấy, không làm bẩn, lem trên giấy trắng','VPP00014.jpg','VPP00003', 'NCC00010',  'TH00011', 'MS00008', 0),
	(dbo.autoIdSP('VPP00015'),N'Chuốt Chì', 100,3000,N'Cái',10,N'Việt Nam',N'Nhựa',N'Chuốt chì với thiết kế dễ sử dụng, chuốt được nhiều loại bút chì có đường kính tiêu chuẩn như bút chì đen, bút chì màu.','VPP00015.jpg','VPP00003', 'NCC00011',  'TH00012', 'MS00003', 0),
	(dbo.autoIdSP('VPP00016'),N'Tập Sinh Viên 4 Ly Ngang 200 Trang', 100,17000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','VPP00016.jpg','VPP00002', 'NCC00012',  'TH00013', 'MS00008', 0),
	(dbo.autoIdSP('VPP00017'),N'Tập Học Sinh Baby Dinosaur B5 48 Trang', 100,11000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','VPP00017.jpg','VPP00002', 'NCC00013',  'TH00014', 'MS00004', 0),
	(dbo.autoIdSP('VPP00018'),N'Vở Freely Life - B5 Kẻ Ngang 120 Trang', 100,17000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','VPP00018.jpg','VPP00002', 'NCC00014',  'TH00015', 'MS00005', 0),
	(dbo.autoIdSP('VPP00019'),N'Vở Dancing Letters - B5 200 Trang', 100,34000,N'Quyển',10,N'Việt Nam',N'Giấy',N'Sản phẩm với mặt giấy láng mịn, viết êm tay, tạo nét chữ đẹp.','VPP00019.jpg','VPP00002', 'NCC00015',  'TH00001', 'MS00003', 0),
	(dbo.autoIdSP('VPP00020'),N'Giấy Kiểm Tra Học Sinh', 100,4000,N'Tờ',10,N'Việt Nam',N'Giấy',N'Dòng kẻ rõ nét, giấy viết không nhòe, không bám bụi.','VPP00020.jpg','VPP00002', 'NCC00016',  'TH00001', 'MS00002', 0),
	(dbo.autoIdSP('VPP00021'),N'Giấy Kiểm Tra B5 Có Chấm', 100,21000,N'Xấp',10,N'Việt Nam',N'Giấy',N'Dòng kẻ rõ nét, giấy viết không nhòe, không bám bụi.','VPP00021.jpg','VPP00002', 'NCC00017',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00022'),N'Bấm Kim', 100,21000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Trong văn phòng, bấm kim là vật dụng không thể thiếu khi bạn muốn liên kết, kẹp các tờ giấy tài liệu quan trọng lại với nhau','VPP00022.jpg','VPP00004', 'NCC00018',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00023'),N'Bấm Kim', 100,21000,N'Cây',10,N'Việt Nam',N'Nhựa',N'Trong văn phòng, bấm kim là vật dụng không thể thiếu khi bạn muốn liên kết, kẹp các tờ giấy tài liệu quan trọng lại với nhau','VPP00023.jpg','VPP00004', 'NCC00019',  'TH00001', 'MS00005', 0),
	(dbo.autoIdSP('VPP00024'),N'Bìa Trình Kí 1 Mặt ', 100,36000,N'Tờ',10,N'Việt Nam',N'Nhựa',N'Được làm từ chất liệu nhựa PS cao cấp ','VPP00024.jpg','VPP00004', 'NCC00020',  'TH00001', 'MS00001', 0),
	(dbo.autoIdSP('VPP00025'),N'Bìa Trình Ký Đôi', 100,54000,N'Tờ',10,N'Việt Nam',N'Nhựa',N'Được làm từ chất liệu nhựa PS cao cấp ','VPP00025.jpg','VPP00004', 'NCC00021',  'TH00001', 'MS00003', 0),
	(dbo.autoIdSP('VPP00026'),N'Kim Bấm', 100,3000,N'Hôp',10,N'Việt Nam',N'Kim Loại',N'Được làm từ thép không gỉ khá cứng cáp và chắc chắn, không bị bung rời khi sử dụng cũng như đảm bảo độ bền cao.','VPP00026.jpg','VPP00004', 'NCC00020',  'TH00001', 'MS00007', 0),
	(dbo.autoIdSP('VPP00027'),N'Kim Bấm', 100,10000,N'Hôp',10,N'Việt Nam',N'Kim Loại',N'Được làm từ thép không gỉ khá cứng cáp và chắc chắn, không bị bung rời khi sử dụng cũng như đảm bảo độ bền cao.','VPP00027.jpg','VPP00004', 'NCC00021',  'TH00001', 'MS00006', 0),
	(dbo.autoIdSP('VPP00028'),N'Kẹp Giấy ', 100,4000,N'Cái',10,N'Việt Nam',N'Kim Loại',N'Đầu tam giác, đầu tròn được sản xuất từ kim loại chất lượng cao, được phủ lớp Niken chống gỉ.','VPP00028.jpg','VPP00004', 'NCC00019',  'TH00001', 'MS00003', 0),
	(dbo.autoIdSP('VPP00029'),N'Hộp Kẹp Bướm', 100,25000,N'Hộp',10,N'Việt Nam',N'Kim Loại',N'Đầu tam giác, đầu tròn được sản xuất từ kim loại chất lượng cao, được phủ lớp Niken chống gỉ.','VPP00029.jpg','VPP00004', 'NCC00010',  'TH00001', 'MS00004', 0),
	(dbo.autoIdSP('VPP00030'),N'Hộp 12 Bút Sáp Màu', 100,25000,N'Hộp',10,N'Việt Nam',N'Sáp',N'Bút sáp màu được sản xuất với thân bằng sáp mềm với thiết kế dễ cầm nắm đối với bàn tay nhỏ bé của các nghệ sĩ trẻ.','VPP00030.jpg','VPP00005', 'NCC00011',  'TH00001', 'MS00002', 0),
	(dbo.autoIdSP('VPP00031'),N'Hộp 8 Bút Sáp Màu', 100,13000,N'Hộp',10,N'Việt Nam',N'Sáp',N'Bút sáp màu được sản xuất với thân bằng sáp mềm với thiết kế dễ cầm nắm đối với bàn tay nhỏ bé của các nghệ sĩ trẻ.','VPP00031.jpg','VPP00005', 'NCC00012',  'TH00001', 'MS00001', 0)
	
select * from ChucVu
insert into ChucVu
values 
	(default,N'Nhân Viên Bán Hàng'),
	(default,N'Nhân Viên Quản Lý');
go
select * from NhanVien
insert into NhanVien
values
	(default,N'Nguyễn Minh Quân', '2002/12/13','064202007178',N'Hẻm 06 Bùi Đình túy Tp.Pleiku Tỉnh Gia Lai','0839131202',1,0,'CV00002'),
	(default,N'Lương Viết Thanh', '2002/04/16','79016296868',N'12 Nguyễn Thái sơn Quận Gò Vấp Tp Hồ Chí Minh','0395247855',1,0,'CV00001'),
	(default,N'Đặng Minh Trung', '2002/07/22','067892488517',N'25 Cửu Long Quận Tân Bình Tp Hồ Chí Minh','0395467935',1,0,'CV00001'),
	(default,N'Dương Văn Hiệu', '2002/10/3','070162946783',N'136 Nguyễn Kiệm Quận Gò Vấp Tp Hồ Chí Minh','0395248745',1,0,'CV00001'),
	(default,N'Phan Võ Tú Anh', '2002/02/15','065729748769',N'58 Nguyễn Xí Quận Bình Thạnh Tp Hồ Chí Minh','0891475425',0,0,'CV00001'),
	(default,N'Nguyễn Bảo Quỳnh', '2002/08/04','062375618437',N'368 Nguyễn Trãi Tp Việt Trì Tỉnh Phú Thọ','0879412873',0,0,'CV00001'),
	(default,N'Nguyễn Thị Mai Phương', '2002/01/09','069416584821',N'45 Hoàng Văn Thụ Tp Đà Nẵng','0824798876',0,0,'CV00001'),
	(default,N'Hoàng Phương Quỳnh', '2002/09/30','061703587925',N'83 Tô Vĩnh Diện Tp Mỹ Tho Tỉnh Tiền Giang','0893021507',0,0,'CV00001'),
	(default,N'Đoàn Huỳnh Ngọc Thảo', '2002/10/07','038655448817',N'06 Ngô Tất Tố Tỉnh Bến Tre','0915725467',0,0,'CV00001'),
	(default,N'Nguyễn Thị Thanh Hằng', '2002/06/01','063664689545',N'78 Nguyễn Thị Minh Khai Tp Đà Nẵng','0916117151',0,0,'CV00001'),
	(default,N'Trần Thị Thanh Thủy', '2002/08/02','066437843762',N'182 Lê Đức Thọ Quận Gò Vấp Tp Hồ Chí Minh','0308241896',0,0,'CV00001'),
	(default,N'Vũ Mỹ Linh', '2002/12/04','061672578631',N'275 CMT8 Quận 10 Tp Hồ Chí Minh','0362578417',0,0,'CV00001'),
	(default,N'Nguyễn Thơ Thùy Dung', '2002/09/24','066043951690',N'19 Lê Lai Tp Thủ Đức','0823131278',0,0,'CV00001'),
	(default,N'Lê Công Hậu', '2002/10/09','061321525875',N'83 Tô Vĩnh Diện Tp Phan Thiết Tỉnh Bình Thuận','0849507914',1,0,'CV00001'),
	(default,N'Nguyễn Văn Thương', '2002/11/27','061654861658',N'25 Lê Lợi Huyện Nhà Bè Tp Hồ Chí Minh','0837732034',1,0,'CV00001'),
	(default,N'Nguyễn Thế Phan', '2002/06/18','061487132687',N'70 Hoàng Hoa Thám Tp KonTum Tỉnh KonTum','0827965247',1,0,'CV00001'),
	(default,N'Trần Thế Sang', '2002/02/13','064876485466',N'157 Nguyễn Tất Thành Tp Tuy Hòa Tỉnh Phú Yên','0735792470',1,0,'CV00001'),
	(default,N'Nguyễn Quang Bảo', '2002/05/25','061546872679',N'57 Nguyễn Văn Trỗi Tp Quy Nhơn Tỉnh Bình Định','0379856472',1,0,'CV00001'),
	(default,N'Trần Thanh Mẫn', '2002/1/26','064202217178',N'48 Tây Sơn, Quận Đống Đa, Hà Nội','0784432489',1,0,'CV00001'),
	(default,N'Nguyễn Đức Hải', '2002/12/18','067792968684',N'40 Vĩnh Hồ, Quận Đống Đa, Hà Nội','0123577924',1,0,'CV00001'),
	(default,N'Nguyễn Khắc Định', '2002/04/25','067892488517',N'229 Tây Sơn, Quận Đống Đa, Hà Nội','0319678456',1,0,'CV00001'),
	(default,N'Trần Quang Phương', '2002/10/08','016862946783',N'19 Đường Láng, Quận Đống Đa, Hà Nội','0389674854',1,0,'CV00001'),
	(default,N'Nguyễn Thúy Anh', '2002/11/15','065729748769',N'592 Trường Chinh, Quận Đống Đa, Hà Nội','0895478763',0,0,'CV00001'),
	(default,N'Dương Thanh Bình', '2002/04/04','062456561843',N'11 Trường Chinh, Khương Trung, Quận Thanh Xuân, Hà Nội','0793441401',1,0,'CV00001'),
	(default,N'Nguyễn Phú Cường', '2002/01/01','019416584821',N'45 264 Hoàng Văn Thái, Quận Thanh Xuân, Hà Nội','0824798876',1,0,'CV00001'),
	(default,N'Bùi Văn Cường', '2002/12/30','051703587925',N'C3/18 Phạm Hùng, Huyện Bình Chánh, TP. HCM','0893021507',0,0,'CV00001'),
	(default,N'Vũ Hải Hà', '2002/07/17','048655448817',N'C3/6 Phạm Hùng, Xã Bình Hưng, Huyện Bình Chánh, TP.Hồ Chí Minh','0917458284',2,0,'CV00001'),
	(default,N'Lê Thị Nga', '2002/04/28','043664689545',N'Số 24 Nguyễn Thái Bình, P. Nguyễn Thái Bình, Q. 1 TP.Hồ Chí Minh','0178315894',2,0,'CV00001'),
	(default,N'Lê Tấn Tới', '2002/02/08','026437843762',N'Số 12 – 14 Song Hành, P. An Phú, Q. 2 Tp Hồ Chí Minh','0177931482',0,0,'CV00001'),
	(default,N'Nguyễn Thị Thanh', '2002/08/04','011672578631',N' 18 Chế Lan Viên , P. Tây Thạnh, Q. Tân Phú Tp Hồ Chí Minh','0679848213',0,0,'CV00001'),
	(default,N'Nguyễn Quang Toán', '2002/03/24','056043951690',N'19 Lê Lai Tp Thủ Đức','0839427541',0,0,'CV00001'),
	(default,N'Trương Ngọc Sơn', '2002/06/09','041321525875',N'60 Đường CN1, Phường Sơn Kỳ, Quận Tân Phú tp Hồ Chí Minh','0364874578',1,0,'CV00001'),
	(default,N'Nguyễn Văn Trường', '2002/08/27','071654861658',N'55A - 55B Ngô Quang Huy, P. Thảo Điền, Q. 2 Tp Hồ Chí Minh','0839471758',1,0,'CV00001'),
	(default,N'Nguyễn Đình Trọng', '2002/10/18','081487132687',N'27 Tú Xương, P. 7, Q. 3 Tp Hồ Chí Minh','0832479647',1,0,'CV00001'),
	(default,N'Lê Văn Sỹ', '2002/07/13','094876485466',N'Số 19 Ngô Văn Năm, P. Bến Nghé, Q. 1 Tp Hồ Chí Minh','0835792470',1,0,'CV00001'),
	(default,N'Nguyễn Hoàng Phúc', '2002/03/25','021546872679',N'38 Nguyễn Thị Minh Khai Tỉnh kiên Giang','0679856472',1,0,'CV00001'),
	(default,N'Lê Công Danh', '2002/04/25','031546872679',N'21 Bùi Đình Túy Tỉnh Đồng Tháp','0739476158',1,0,'CV00001'),
	(default,N'Hoàng Thùy Trang', '2002/05/02','064546235239',N'35 Hùng Vương Tỉnh Quảng Trị','0369874514',0,0,'CV00001'),
	(default,N'Nguyễn Hoàng Yến', '2002/06/15','071468741239',N'57 Xô Viết Nghệ Tĩnh Quận Bình Thạnh Tp Hồ Chí Minh','0581497654',0,0,'CV00001'),
	(default,N'Võ Thanh Hồng', '2002/10/28','081946872219',N'76 Quang Trung Tỉnh Tây Ninh','0837276521',0,0,'CV00001'),
	(default,N'Đặng Minh Thành', '2002/11/06','061546872419',N'58 Hoàng Hoa Thám Tỉnh Gia Lai','0807985720',1,0,'CV00001'),
	(default,N'Hoàng Thị Khánh Vân', '2002/12/01','064684254793',N'337 Ngô Tất Tố Quận 3 Tp Hồ Chí Minh','0837984754',0,0,'CV00001'),
	(default,N'Trần Quang Đại', '2002/09/05','069873135413',N'82 Hai Bà Trưng Tỉnh Bà Rịa - Vũng Tàu','0746915874',1,0,'CV00001'),
	(default,N'Đinh Ngọc Hoa', '2002/01/12','021343314644',N'55 Nguyễn Huệ Tỉnh Hà Giang','0369745821',0,0,'CV00001'),
	(default,N'Đinh Ngọc Khanh', '2002/07/22','021354683356',N'97 Nguyễn Tất Thành Tỉnh Cao Bằng','0215784512',0,0,'CV00001'),
	(default,N'Bùi Thanh Thúy', '2002/04/23','048630146848',N'268 Đinh Bộ Lĩnh Tp Hồ Chí Minh','0869451457',0,0,'CV00001'),
	(default,N'Hoàng Thùy Linh', '2002/08/14','061548658654',N'810 Lê Đức Thọ Tp Hồ Chí Minh','1479365487',0,0,'CV00001'),
	(default,N'Nguyễn Văn Thanh', '2002/08/19','061546146489',N'41 Nguyễn Văn Lượng Tỉnh Kiên Giang','0379856472',1,0,'CV00001')
go
select * from TaiKhoan
insert into TaiKhoan
values	('NV00001','123','NV00001'),
		('NV00002','123','NV00002'),
		('NV00003','123','NV00003'),
		('NV00004','123','NV00004'),
		('NV00005','123','NV00005'),
		('NV00006','123','NV00006'),
		('NV00007','123','NV00007'),
		('NV00008','123','NV00008'),
		('NV00009','123','NV00009'),
		('NV00010','123','NV00010'),
		('NV00011','123','NV00011'),
		('NV00012','123','NV00012'),
		('NV00013','123','NV00013'),
		('NV00014','123','NV00014'),
		('NV00015','123','NV00015'),
		('NV00016','123','NV00016'),
		('NV00017','123','NV00017'),
		('NV00018','123','NV00018'),
		('NV00019','123','NV00019'),
		('NV00020','123','NV00020'),
		('NV00021','123','NV00021'),
		('NV00022','123','NV00022'),
		('NV00023','123','NV00023'),
		('NV00024','123','NV00024'),
		('NV00025','123','NV00025'),
		('NV00026','123','NV00026'),
		('NV00027','123','NV00027'),
		('NV00028','123','NV00028'),
		('NV00029','123','NV00029'),
		('NV00030','123','NV00030'),
		('NV00031','123','NV00031'),
		('NV00032','123','NV00032'),
		('NV00033','123','NV00033'),
		('NV00034','123','NV00034'),
		('NV00035','123','NV00035'),
		('NV00036','123','NV00036'),
		('NV00037','123','NV00037'),
		('NV00038','123','NV00038'),
		('NV00039','123','NV00039'),
		('NV00040','123','NV00040'),
		('NV00041','123','NV00041'),
		('NV00042','123','NV00042'),
		('NV00043','123','NV00043'),
		('NV00044','123','NV00044'),
		('NV00045','123','NV00045'),
		('NV00046','123','NV00046'),
		('NV00047','123','NV00047'),
		('NV00048','123','NV00048')
go
select * from KhachHang
insert into KhachHang
values
	(default,N'Trần Hưng An','2002/12/20',N'Gò Vấp, TP.HCM','0396979388',1,1),
	(default,N'Nguyễn Hoàng	Anh','2002/09/03',N'Bình Thạnh, Tp.HCM','0744244188',1,0),
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

