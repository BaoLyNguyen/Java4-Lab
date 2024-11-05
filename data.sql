CREATE DATABASE PolyOE
GO

Use PolyOE
GO
CREATE TABLE Users(
	Id NVARCHAR(20) NOT NULL,
	Password NVARCHAR(50) NOT NULL,
	Fullname NVARCHAR(50) NOT NULL,
	Email NVARCHAR(50) NOT NULL,
	Admin BIT NOT NULL,
	PRIMARY KEY (Id)
	)

INSERT INTO Users (id,Password,Fullname,Email,Admin)
VALUES ('USR0001','123456',N'Bảo Ly','bly@gmail.com',1)

INSERT INTO Users (id,Password,Fullname,Email,Admin)
VALUES ('USR0002','123456','Phan Thanh Tu','tu@abc.com',0),
('USR0003','123456','Tran Phan Trung','trung@fpt.edu.vn',0),
('USR0004','123456','Tran Thi Phuong','phuongtran@fpt.edu.vn',0),
('USR0005','123456',N'Nguyễn Tiến Đạt','tdat@gmail.com',0),
('USR0006','123456','Nguyen Thi Kim Nguyen','nguyen@abc.com',1),
('USR0007','123456',N'Hồ Kim Nhiễn','knhien@gmail.com',0),
('USR0008','123456',N'Hồ Hoài Anh','hanh@fpt.edu.vn',0),
('USR0009','123456',N'Trương Minh Tiến','mt@gmail.com',0),
('USR0010','123456',N'Nhi Trần','nhitran@gmail.com',1),
('USR0011','123456',N'Nhi Lầy','nhlay@gmail.com',0),
('USR0012','123456',N'Việt Phương Thoa','thoaviet@fpt.edu.vn',0),
('USR0013','123456',N'Viên Vibi','vien@gmail.com',0),
('USR0014','123456',N'Thanh Đoàn','thdoan@gmail.com',0),
('USR0015','123456',N'Hà Trí Quang','haquang@gmail.com',0)