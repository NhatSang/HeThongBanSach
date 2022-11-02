use BanSach
go
/*Sách*/
select sp.maSP,sp.tenSP, sp.namXB_SX, sp.soLuong,sp.donGia,sp.donVi,sp.VAT , sp.soTrang, sp.tuoiGioiHan, sp.nguoiDich, sp.moTa,sp.hinhAnh,
lsp.*,ncc.maNCC, ncc.tenNCC,nxb.*,tg.tenTG,lb.*,cdh.*
from SanPham sp 
left join LoaiSanPham lsp on sp.maLoai = lsp.maLoai 
left join NhaCungCap ncc on sp.maNCC = ncc.maNCC
left join NhaXuatBan nxb on sp.maNXB = nxb.maNXB
left join TacGia tg on sp.maTG = tg.maTG
left join LoaiBia lb on sp.maLB = lb.maLB
left join CapDoHoc cdh on sp.maCDH = cdh.maCDH
where maSP not like 'VPP%' and sp.trangThai = 0
go
/*vpp*/
select sp.maSP,sp.tenSP, sp.soLuong,sp.donGia,sp.donVi,sp.VAT ,sp.xuatXu,sp.chatLieu, sp.moTa,sp.hinhAnh,
lsp.*,ncc.maNCC, ncc.tenNCC,th.*,ms.*
from SanPham sp 
left join LoaiSanPham lsp on sp.maLoai = lsp.maLoai 
left join NhaCungCap ncc on sp.maNCC = ncc.maNCC
left join ThuongHieu th on sp.maTH = th.maTH
left join MauSac ms on sp.maMau = ms.maMau
where maSP like 'VPP%' and sp.trangThai = 0
/* lấy danh sách NCC */
select * 
from NhaCungCap
where trangThai = 0
/* xóa nhà cung cấp*/
update NhaCungCap
set trangThai = 1
where maNCC = 'NCC00001' -- viết câu lệnh trong hàm thì thay thành maNCC = ?
-- xóa khách hàng
update KhachHang
set trangThai = 1
where maKH = 'KH2022102900002' -- viết câu lệnh trong hàm thì thay thành maNKH = ?
-- xóa Nhân viên
update NhanVien
set trangThai = 1
where maNV = 'NV00003' -- viết câu lệnh trong hàm thì thay thành maNV = ?
-- xóa sanr phẩm
update SanPham
set trangThai = 1
where maSP = 'SVH00001' -- viết câu lệnh trong hàm thì thay thành maNV = ?
-- tìm sản phẩm
select maSP,tenSP,hinhAnh,donGia, donVi, soLuong, VAT, ncc.maNCC, ncc.tenNCC from SanPham sp 
join NhaCungCap ncc on sp.maNCC = ncc.maNCC
where (tenSP = N'Những Đêm Không Ngủ Những Ngày Chậm Trôi' or maSP = 'SVH00001') and sp.trangThai = 0
-- get ds nhân viên
Select nv.*,cv.tenCV from NhanVien nv
join ChucVu cv on nv.maCV = cv.maCV
where trangThai = 0
-- them hoa don
select * from SanPham
insert into HoaDon 
values (default,'2022-11-02',1,0,'NV00002','KH2022102900001')
select * from HoaDon hd join ChiTietHoaDon ct on hd.maHD=ct.maHD
delete from HoaDon where maHD = '20221102200001'
select ct.*,sp.tenSP,sp.donGia,sp.VAT,sp.soLuong from ChiTietHoaDon ct join SanPham sp on ct.maSP = sp.maSP
select dbo.autoIDHD()
update SanPham set soLuong = 100 where maSP = 'SVH00001'