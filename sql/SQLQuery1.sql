create database Test
use Test
select convert(varchar(2), GETDATE(), 108) 
go
create function autoIdHD()
returns VARCHAR(14)
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
DROP FUNCTION IF EXISTS autoIdHD;
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
DROP FUNCTION IF EXISTS autoIdKH;
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
		if @tbl = 'LSP'
			select @len = COUNT(maLoai) FROM LoaiSanPham
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
	end
	if @len = 0
		set @id = 0
	else
	begin
		if @tbl = 'NCC'
			select @id = max(right(maNCC,5)) FROM NhaCungCap
		else
		begin
			if @tbl = 'LSP'
				select @id = max(right(maLoai,5)) FROM LoaiSanPham
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
DROP FUNCTION IF EXISTS autoID3;
go
create function autoIdSP(@loai as int)
returns varchar(8)
as
begin
	declare @id varchar(8)
	declare @ml varchar(3)
	if(@loai = 1)
		set @ml = 'SGK'
	else
	begin
		if(@loai = 2)
			set @ml = 'SVH'
		else
		begin
			if(@loai = 3)
				set @ml = 'STN'
			else
			begin
				if(@loai = 4)
					set @ml = 'SKT'
				else
				begin
					if(@loai = 5)
						set @ml = 'SNN'
					else
					begin
						if(@loai = 6)
							set @ml = 'VPP'
					end
				end
			end
		end
	end
	
	if (select COUNT(maSP) FROM SanPham where convert(int,right(maLoai,5)) = @loai) = 0
		set @id = 0
	else
		select @id = max(right(maSP,5)) from SanPham where convert(int,right(maLoai,5)) = @loai 
	select @id = case
		when @id < 9 THEN @ml + '0000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 99 THEN @ml + '000' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 999 THEN @ml + '00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 9999 THEN @ml + '0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		when @id < 99999 THEN @ml + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
	end
	return @id
end
go
DROP FUNCTION IF EXISTS autoIdSP;
go
create function autoTK()
returns varchar(7)
as
begin
	declare @tenTk varchar(7)
	select @tenTK = 'NV' + convert(char,convert(int,max(right(maNV,5)))) from NhanVien
	return @tenTK
end
go
DROP FUNCTION IF EXISTS autoTK;
go
CREATE TABLE KhachHang(
	maKH VARCHAR(15) PRIMARY KEY CONSTRAINT IDKH1 DEFAULT DBO.autoIdKH(),
	HOTEN NVARCHAR(50) NOT NULL,
	SDT VARCHAR(11) NULL,
	DIACHI NVARCHAR(100) NULL,
	EMAIL VARCHAR(50) NULL
)
go
CREATE TABLE HoaDon(
	MAHD VARCHAR(14) PRIMARY KEY CONSTRAINT IDKH DEFAULT DBO.autoIdHD(),
	NgayLap Datetime NOT NULL
)
go
CREATE TABLE SanPham(
	maSP VARCHAR(8) PRIMARY KEY,
	maLoai varchar(8) not null
)
go
CREATE TABLE NhanVien(
	maNV VARCHAR(7) PRIMARY KEY CONSTRAINT IDNV DEFAULT DBO.autoID2('NV'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE TaiKhoan(
	tenTK VARCHAR(7) PRIMARY KEY CONSTRAINT IDTK DEFAULT DBO.autoTK(),
	maNV varchar(7) foreign key references NhanVien(maNV) on delete cascade
)
go
CREATE TABLE ChucVu(
	maCV VARCHAR(7) PRIMARY KEY CONSTRAINT IDCV DEFAULT DBO.autoID2('CV'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE TacGia(
	maTG VARCHAR(7) PRIMARY KEY CONSTRAINT IDTG DEFAULT DBO.autoID2('TG'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE LoaiBia(
	maLB VARCHAR(7) PRIMARY KEY CONSTRAINT IDLB DEFAULT DBO.autoID2('LB'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE ThuongHieu(
	maTH VARCHAR(7) PRIMARY KEY CONSTRAINT IDTH DEFAULT DBO.autoID2('TH'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE MauSac(
	maMau VARCHAR(7) PRIMARY KEY CONSTRAINT IDMS DEFAULT DBO.autoID2('MS'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE NhaCungCap(
	maNCC VARCHAR(8) PRIMARY KEY CONSTRAINT IDNCC DEFAULT DBO.autoID3('NCC'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE LoaiSanPham(
	maLoai VARCHAR(8) PRIMARY KEY CONSTRAINT IDLSP DEFAULT DBO.autoID3('LSP'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE NhaXuatBan(
	maNXB VARCHAR(8) PRIMARY KEY CONSTRAINT IDNXB DEFAULT DBO.autoID3('NXB'),
	ten varchar(50) NOT NULL
)
go
CREATE TABLE CapDoHoc(
	maCDH VARCHAR(8) PRIMARY KEY CONSTRAINT IDCDH DEFAULT DBO.autoID3('CDH'),
	ten varchar(50) NOT NULL
)
go
insert into KHACHHANG (HOTEN,SDT,DIACHI,EMAIL)
values ('Sang','','','')
go
select * from HoaDon
go
select * from NhanVien
go
select * from ChucVu
go
select * from TacGia
go
select * from LoaiBia
go
select * from KhachHang
go
select * from SanPham
go
select * from NhaCungCap
go
select * from TaiKhoan
go
insert into HoaDon(NgayLap)
values ('2022-09-25')
go
insert into NhanVien(ten)
values ('Sang')
go
insert into ChucVu(ten)
values ('Sang')
go
insert into TacGia(ten)
values ('Sang')
go
insert into LoaiBia(ten)
values ('Sang')
go
insert into ThuongHieu(ten)
values ('Sang')
go
insert into MauSac(ten)
values ('Sang')
go
insert into NhaCungCap(ten)
values ('Sang')
go
insert into LoaiSanPham(ten)
values ('Sang')
go
insert into KhachHang(HOTEN)
values ('Sang')
go
insert into TaiKhoan(tenTK)
values ('a')
go
insert into SanPham
values (dbo.autoIdSP(3),'LSP00003')
go
SELECT COUNT(MAHD) FROM HoaDon where day(NgayLap)= DAY(GETDATE()) and MONTH(NgayLap)
=MONTH(GETDATE()) and YEAR(NgayLap) = YEAR(GETDATE())

go 
select top 1 RIGHT(MAHD, 9) FROM HoaDon ORDER BY MAHD DESC
GO 
select convert(varchar(2), '20220926')
select year(getdate())
go
select max(ascii(SUBSTRING(maSP,4,1))) from SanPham where convert(int,right(maLoai,5)) = 1
go
select max(right(maSP,2)) from SanPham where convert(int,right(maLoai,5)) = 2
go
SELECT TOP 1 right(maSP,1) FROM SanPham where convert(int,right(maLoai,5)) = 1 ORDER BY maSP DESC
go
delete from NhanVien where maNV = 'NV00001'
delete from TaiKhoan where maNV = 'NV00001'
delete from SanPham where maSP = 'STN000'
delete from NhaCungCap where maNCC = 'NCC00001'