create table GiaSu
(
	MaGiaSu int not null primary key,
	TenGiaSu Nvarchar(20) not null,
	GioiTinh Text,
	NgaySinh DateTime,
	NoiSinh Nvarchar(30),
	DiaChi Nvarchar(50),
	SoDienThoai Varchar(24),
	Email Varchar(50)

)
create table MonHoc
(
	MaMonHoc int not null,
	TenMonHoc Nvarchar(10) not null,
	SoTiet int
)
create table Lop
(
	TenMonHoc Nvarchar(10) not null,
	
)
alter table GiaSu add constraint pk_MaGiaSu primary key(MaGiaSu)
alter table MonHoc add constraint pk_MaMonHoc primary key(MaMonHoc)