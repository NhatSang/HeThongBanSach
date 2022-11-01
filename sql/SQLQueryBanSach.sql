create database BanSach
use BanSach
go
create function autoIdHD()
returns varchar(14)
as
begin
	declare @id varchar(14);
	declare @ca varchar(1);
	declare @len varchar(5);
	if (select convert(varchar(2), GETDATE(), 108))>=8 and (select convert(varchar(2), GETDATE(), 108))<=15
		set @ca = 1
	else
		set @ca = 2
	select @len =COUNT(maHD) from HoaDon where day(NgayLap)= DAY(GETDATE()) and MONTH(NgayLap)
=MONTH(GETDATE()) and YEAR(NgayLap) = YEAR(GETDATE())
	if @len = 0
		set @id = 0
	else
		set @id = @len
	select @id = case
		when @id < 9 then convert(varchar,GETDATE(),112)+ @ca + '0000'+ convert(char,convert(int,@id)+1) 
		when @id < 99 then convert(varchar,GETDATE(),112)+ @ca + '000'+ convert(char,convert(int,@id)+1)
		when @id < 999 then convert(varchar,GETDATE(),112)+ @ca + '00'+ convert(char,convert(int,@id)+1)
		when @id < 9999 then convert(varchar,GETDATE(),112)+ @ca + '0'+ convert(char,convert(int,@id)+1)
		when @id < 99999 then convert(varchar,GETDATE(),112)+ @ca + convert(char,convert(int,@id)+1)
		end
	return @id
end
go
create function autoIdKH()
returns VARCHAR(15)
as
begin
	declare @id varchar(15);
	declare @len varchar(5);

	select @len =COUNT(maKH) from KhachHang 
	where (select SUBSTRING(maKH,3,4)) = year(getdate()) and (select SUBSTRING(maKH,7,2)) = month(getdate()) and (select SUBSTRING(maKH,9,2)) = day(getdate())
	if @len = 0
		set @id = 0
	else
		set @id = @len
	select @id = case
		when @id < 9 then 'KH' + convert(varchar,GETDATE(),112)+ '0000'+ convert(char,convert(int,@id)+1) 
		when @id < 99 then 'KH' + convert(varchar,GETDATE(),112)+ '000'+ convert(char,convert(int,@id)+1)
		when @id < 999 then 'KH' + convert(varchar,GETDATE(),112)+ '00'+ convert(char,convert(int,@id)+1)
		when @id < 9999 then 'KH' + convert(varchar,GETDATE(),112)+ '0'+ convert(char,convert(int,@id)+1)
		when @id < 99999 then 'KH' + convert(varchar,GETDATE(),112)+ convert(char,convert(int,@id)+1)
		end
	return @id
end
go
create function autoID2(@tbl varchar(2))
returns varchar(7)
AS
BEGIN
	DECLARE @id VARCHAR(7)
	DECLARE @len VARCHAR(5)
	if @tbl = 'NV'
		select @len = COUNT(maNV) FROM NhanVien
	else
	begin
		if @tbl = 'CV'
			select @len = COUNT(maCV) FROM ChucVu
		else
		begin
			if @tbl = 'TG'
				select @len = COUNT(maTG) FROM TacGia
			else
			begin
				if @tbl = 'LB'
					select @len = COUNT(maLB) FROM LoaiBia
				else
				begin
					if @tbl = 'TH'
						select @len = COUNT(maTH) FROM ThuongHieu
					else
					begin
						if @tbl = 'MS'
							select @len = COUNT(maMau) FROM MauSac
					end
				end
			end
		end
	end
	if @len = 0
		set @id = 0
	else
	begin
		if @tbl = 'NV'
			select @id = max(right(maNV,5)) FROM NhanVien
		else
		begin
			if @tbl = 'CV'
				select @id = max(right(maCV,5)) FROM ChucVu
			else
			begin
				if @tbl = 'TG'
					select @id = max(right(maTG,5)) FROM TacGia
				else
				begin
					if @tbl = 'LB'
						select @id = max(right(maLB,5)) FROM LoaiBia
					else
					begin
						if @tbl = 'TH'
							select @id = max(right(maTH,5)) FROM ThuongHieu
						else
						begin
							if @tbl = 'MS'
								select @id = max(right(maMau,5)) FROM MauSac
						end
					end
				end
			end
		end
	end
	select @id = case
		when @id < 9 THEN @tbl + '0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 99 THEN @tbl + '000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 999 THEN @tbl + '00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 9999 THEN @tbl + '0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 99999 THEN @tbl + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		end
	return @id
end
go
create function autoID3(@tbl varchar(3))
returns varchar(8)
AS
BEGIN
	DECLARE @id VARCHAR(8)
	DECLARE @len VARCHAR(5)
	if @tbl = 'NCC'
		select @len = COUNT(maNCC) FROM NhaCungCap
	else
	begin
		if @tbl = 'NXB'
			select @len = COUNT(maNXB) FROM NhaXuatBan
		else
		begin
			if @tbl = 'CDH'
				select @len = COUNT(maCDH) FROM CapDoHoc
		end
	end
	if @len = 0
		set @id = 0
	else
	begin
		if @tbl = 'NCC'
			select @id = max(right(maNCC,5)) FROM NhaCungCap
		else
		begin
			if @tbl = 'NXB'
				select @id = max(right(maNXB,5)) FROM NhaXuatBan
			else
			begin
				if @tbl = 'CDH'
					select @id = max(right(maCDH,5)) FROM CapDoHoc
			end
		end
	end
	select @id = case
		when @id < 9 THEN @tbl + '0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 99 THEN @tbl + '000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 999 THEN @tbl + '00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 9999 THEN @tbl + '0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 99999 THEN @tbl + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		end
	return @id
end
go
create function autoIdLSP(@loai as varchar(3))
returns varchar(8)
as
begin
	declare @id varchar(8)
	set @id = @loai
	declare @len int
	declare @lid varchar(5)
	
	select @len = COUNT(maLoai) FROM LoaiSanPham where left(maLoai,3) like @loai
	if @len = 0
		set @len +=1
	else
		begin
			select @lid = right(max(maLoai),5) from LoaiSanPham where left(maLoai,3) like @loai
			set @len = convert(int,@lid)+1
		end
	while len(@id)< (8- len(convert(varchar,@len)))
	begin
		set @id += '0'
	end
	set @id += convert(varchar,@len)
	return @id
end
go
create function autoIdSP(@loai as varchar(8))
returns varchar(8)
as
begin
	declare @id varchar(8)
	set @id = left(@loai,3)
	declare @len int
	declare @lid varchar(5)
	
	select @len = COUNT(maSP) FROM SanPham where left(maLoai,3) like left(@loai,3)
	if @len = 0
		set @len +=1
	else
		begin
			select @lid = right(max(maSP),5) from SanPham where left(maLoai,3) like left(@loai,3)
			set @len = convert(int,@lid)+1
		end
	while len(@id)< (8- len(convert(varchar,@len)))
	begin
		set @id += '0'
	end
	set @id += convert(varchar,@len)
	return @id
end
go
create function autoTK()
returns varchar(7)
as
begin
	declare @tenTk varchar(7)
	select @tenTK = 'NV' + max(right(maNV,5)) from NhanVien
	return @tenTK
end

go
create table ChucVu(
	maCV varchar(7) primary key constraint IDCV default dbo.autoID2('CV'),
	tenCV nvarchar(30) not null
)
go
create table NhanVien(
	maNV varchar(7) primary key constraint IDNV default dbo.autoID2('NV'),
	hoTen nvarchar(50) not null,
	ngaySinh date not null,
	cccd varchar(12) not null,
	diaChi nvarchar(100),
	sdt varchar(10) not null,
	gioiTinh bit not null,
	trangThai bit not null,
	maCV varchar(7) foreign key references ChucVu(maCV)
)
go
create table TaiKhoan(
	tenTK varchar(7) primary key constraint IDTK default dbo.autoTK(),
	matKhau varchar(15) not null,
	maNV varchar(7) foreign key references NhanVien(maNV) on delete cascade
)
go
create table KhachHang(
	maKH varchar(15)  primary key constraint IDKH default dbo.autoIdKH(),
	hoTen nvarchar(50) not null,
	ngaySinh date not null,
	diaChi nvarchar(100),
	sdt varchar(10) not null,
	gioiTinh bit not null,
	trangThai bit not null,
)
go
create table HoaDon(
	maHD varchar(14) primary key constraint IDHD default dbo.autoIdHD(),
	ngayLap date not null,
	caLap int not null,
	trangThai bit not null,
	maNV varchar(7) foreign key references NhanVien(maNV),
	maKH varchar(15) foreign key references KhachHang(maKH)
)
go
create table NhaCungCap(
	maNCC varchar(8) primary key constraint IDNCC default dbo.autoID3('NCC'),
	tenNCC nvarchar(50) not null,
	nguoiDaiDien nvarchar(50) not null,
	sdt varchar(10) not null,
	diaChi nvarchar(100),
	trangThai bit not null
)
go
create table NhaXuatBan(
	maNXB varchar(8) primary key constraint IDNXB default dbo.autoID3('NXB'),
	tenNXB nvarchar(50) not null
)
go
create table LoaiSanPham(
	maLoai varchar(8) primary key constraint IDLSP default dbo.autoID3('LSP'),
	tenLoai nvarchar(50) not null
)
go
create table CapDoHoc(
	maCDH varchar(8) primary key constraint IDCDH default dbo.autoID3('CDH'),
	capHoc nvarchar(50) not null,
	capLop int not null
)
go
create table TacGia(
	maTG varchar(7) primary key constraint IDTG default dbo.autoID2('TG'),
	tenTG nvarchar(50) not null
)
go
create table LoaiBia(
	maLB varchar(7) primary key constraint IDLB default dbo.autoID2('LB'),
	tenLB nvarchar(50) not null
)
go
create table ThuongHieu(
	maTH varchar(7) primary key constraint IDTH default dbo.autoID2('TH'),
	tenTH nvarchar(50) not null
)
go
create table MauSac(
	maMau varchar(7) primary key constraint IDMM default dbo.autoID2('MS'),
	mau nvarchar(50) not null
)
go
create table SanPham(
	maSP varchar(8) primary key,
	tenSP nvarchar(100) not null,
	namXB_SX int,
	soLuong int not null,
	donGia float not null,
	donVi nvarchar(10) not null,
	VAT int not null,
	soTrang int,
	tuoiGioiHan int,
	nguoiDich nvarchar(50),
	xuatXu nvarchar(50),
	chatLieu nvarchar(50),
	moTa nvarchar(1000),
	hinhAnh varchar(100),
	maLoai varchar(8) foreign key references LoaiSanPham(maLoai),
	maNCC varchar(8) foreign key references NhaCungCap(maNCC),
	maNXB varchar(8) foreign key references NhaXuatBan(maNXB),
	maTG varchar(7) foreign key references TacGia(maTG),
	maLB varchar(7) foreign key references LoaiBia(maLB),
	maCDH varchar(8) foreign key references CapDoHoc(maCDH),
	maTH varchar(7) foreign key references ThuongHieu(maTH),
	maMau varchar(7) foreign key references MauSac(maMau),
	trangThai bit not null
)
go
create table ChiTietHoaDon(
	giaBan float not null,
	soLuong int not null,
	maSP varchar(8) not null foreign key references SanPham(maSP),
	maHD varchar(14) not null foreign key references HoaDon(maHD) on delete cascade
)
go
alter table ChiTietHoaDon add constraint PL_CTHD primary key (maSP,maHD)
go
