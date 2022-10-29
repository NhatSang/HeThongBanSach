use BanSach
go
/*Sách*/
select sp.maSP,sp.tenSP, sp.namXB_SX, sp.soLuong,sp.donGia,sp.VAT ,sp.donVi, sp.soTrang, sp.tuoiGioiHan, sp.nguoiDich, sp.moTa,sp.hinhAnh,
lsp.*,ncc.maNCC, ncc.tenNCC,nxb.*,tg.*,lb.*,cdh.*
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
select sp.maSP,sp.tenSP, sp.soLuong,sp.donGia,sp.VAT ,sp.donVi,sp.xuatXu,sp.chatLieu, sp.moTa,sp.hinhAnh,
lsp.*,ncc.maNCC, ncc.tenNCC,th.*,ms.*
from SanPham sp 
left join LoaiSanPham lsp on sp.maLoai = lsp.maLoai 
left join NhaCungCap ncc on sp.maNCC = ncc.maNCC
left join ThuongHieu th on sp.maTH = th.maTH
left join MauSac ms on sp.maMau = ms.maMau
where maSP like 'VPP%' and sp.trangThai = 0