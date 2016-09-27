create database TrungTamGiaSu
create table GiaSu
(
	MaGiaSu char(3) not null primary key,
	HoGiaSu nvarchar(10) not null,
	TenGiaSu nvarchar(10) not null,
	GioiTinh nchar(5),
	NgaySinh datetime not null,
	NoiSinh nvarchar(50),
	DiaChi nvarchar(50),
	SoDienThoai varchar,
	Email varchar(50)

)
create table MonHoc
(
	MaMonHoc char(2) not null primary key,
	TenMonHoc nvarchar(20) not null,

)
create table LopDay
(
	MaLop char(2) not null primary key,
	LopDay int not null,
	MonDay nvarchar(10),
	SoBuoi int ,
	ThoiGianDay nvarchar,
	KhuVucDay nvarchar(50),
	MaMonHoc char(2) not null,
	MaGiaSu char(3) not null
)
create table DangNhap
(
	MaTaiKhoan char(4) not null primary key,
	TenDangNhap varchar(30) not null,
	MatKhau  varchar(30) not null,
)
/*==========================TAO KHOA CHINH==============================*/
alter table GiaSu add constraint pk_MaGiaSu primary key(MaGiaSu)
alter table MonHoc add constraint pk_MaMonHoc primary key(MaMonHoc)
alter table LopDay add constraint pk_MaLop primary key(MaLop)
alter table DangNhap add constraint pk_MaTaiKhoan primary key(MaTaiKhoan)

/*==========================TAO KHOA NGOAI==============================*/
alter table LopDay add constraint fk_MaMonHoc foreign key(MaMonHoc) references MonHoc(MaMonHoc)
alter table LopDay add constraint fk_MaGiaSu foreign key(MaGiaSu) references GiaSu(MaGiaSu)

/*==========================NHAP DU LIEU================================*/
/*=========================NHAP DU LIEU GIA SU=============================*/
insert into GiaSu(MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email)
values ('A01',N'Nguyễn Thị',N'Lan',N'Nữ','23/02/1990',N'Hà Nội',N'12 Nguyễn Văn Bảo','0123456789','nguyenthilan@gmail.com')

insert into GiaSu(MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email)
values ('A02',N'Tran Minh',N'Trung',N'Nam','12/10/1996',N'Đồng Nai',N'220/39 Hoàng Hoa Thám','01285919104','minhtrung@gmail.com')

insert into GiaSu(MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email)
values ('A03',N'Lê',N'Khánh',N'Nam','23/02/1994',N'Bình Dương',N'30 Lê Dức Thọ','0111222333444','lekhanh@gmail.com')

insert into GiaSu(MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email)
values ('A04',N'Đinh Tấn',N'Vương',N'Nam','13/22/1989',N'TP Hồ Chí Minh',N'25 Quang Trung','09623456784','tanvuong@gmail.com')

insert into GiaSu(MaGiaSu,HoGiaSu,TenGiaSu,GioiTinh,NgaySinh,NoiSinh,DiaChi,SoDienThoai,Email)
values ('A05',N'Trương Thanh',N'Lâm',N'Nam','11/02/1993',N'Cần Thơ',N'56 Gò Vấp','092433678409','thanhlam@gmail.com')

/*==========================NHAP DU LIEU MON HOC=================================*/
insert into MonHoc(MaMonHoc,TenMonHoc)
values('01',N'Toán')

insert into MonHoc(MaMonHoc,TenMonHoc)
values('02',N'Lý')

insert into MonHoc(MaMonHoc,TenMonHoc)
values('03',N'Hóa')

insert into MonHoc(MaMonHoc,TenMonHoc)
values('04',N'Văn')

insert into MonHoc(MaMonHoc,TenMonHoc)
values('05',N'Anh')

/*==========================NHAP DU LIEU LOP HOC=================================*/
insert into LopDay(MaLop,LopDay,MonDay,SoBuoi,ThoiGianDay,KhuVucDay,MaMonHoc,MaGiaSu)
values('L1',12,N'Toán',3,N'Thứ 2,4,6 chiều 5h-8h',N'Q.Gò Vấp','01','A01')

insert into LopDay(MaLop,LopDay,MonDay,SoBuoi,ThoiGianDay,KhuVucDay,MaMonHoc,MaGiaSu)
values('L2',12,N'Lý',3,N'Thứ 3,5,7 chiều 5h-8h',N'Q.Gò Vấp','02','A02')

insert into LopDay(MaLop,LopDay,MonDay,SoBuoi,ThoiGianDay,KhuVucDay,MaMonHoc,MaGiaSu)
values('L3',12,N'Hóa',3,N'Thứ 4,6,CN chiều 3h-5h',N'Q.Bình Thạnh','03','A03')

insert into LopDay(MaLop,LopDay,MonDay,SoBuoi,ThoiGianDay,KhuVucDay,MaMonHoc,MaGiaSu)
values('L4',12,N'Văn',3,N'Thứ 2,5,7 chiều 5h-8h',N'Q.1','04','A04')

insert into LopDay(MaLop,LopDay,MonDay,SoBuoi,ThoiGianDay,KhuVucDay,MaMonHoc,MaGiaSu)
values('L5',12,N'Anh',3,N'Thứ 3,6,CN chiều 4h-6h',N'Q.12','05','A05')

select * from MonHoc