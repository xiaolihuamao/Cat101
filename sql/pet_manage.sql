create database pet_manage;
use pet_manage;

DROP TABLE IF EXISTS `User`;
#用户信息表
create table User
(
    Uid int auto_increment primary key, #用户编号
    Uname varchar(20) not null, #账号
    Upwd varchar(20) not null,  #密码
    Uxname varchar(20) not null,  #用户名
    Usex char(2) ,  #用户性别
    Utel varchar(20) not null,  #电话
    Usite varchar(50) not null,  #地址
    Utype int not null,  # 角色类型：普通用户=0；社团管理员=1
    Usrl varchar(100) null, #头像地址（可以为空，如果有准备让用户上传头像这个的话，得加上这个属性吧）写了Usrl，担心Url关键字撞了
    Uinfo varchar(100) null  #信息介绍（可以用一句话简单介绍自己，有点标签的意思）
);

DROP TABLE IF EXISTS `Cat`;
#猫猫信息表
create table Cat
(
    Cid int auto_increment primary key,	#猫编号
    Cname varchar(20) not null,	    #名称
    Ccolor varchar(20) not null,    #毛色
    Curl varchar(100) not null,		#图片地址
    Cinfo varchar(100) not null ,   #信息描述
    Cisadopt int not null  #领养状态：未领养=0 待审核=1，审核通过=2，审核不通过=3，已领养=4
);



DROP TABLE IF EXISTS `Adopt`;
#领养信息表
create table Adopt
(
    Aid int auto_increment primary key,	#猫领养编号
    Uid int not null ,  #用户编号
    Cid int not null , #猫编号
    Ainfo varchar(100) not null , #申请描述
    foreign key(Uid) references User(Uid), #用户编号作为外码
    foreign key(Cid) references Cat(Cid) #猫编号作为外码
);



DROP TABLE IF EXISTS `Post`;
#帖子信息表
create table Post
(
    Pid   int auto_increment primary key, #收藏编号
    Purl  varchar(100) null,              #图片（可以为空，可以只发表文字，帖子里面不包含图片），初始值为空
    Pinfo varchar(100) null,              #帖子描述（可以为空，可以只发表文字，帖子里面不包含图片），初始值为空
    Ptime date not null,                  #发帖时间(但是感觉要是有这个时间的话，得系统自动生成，记录到月份应该就行了）
    Psite varchar(50) null,               #发帖地点（可以为空，可以发出自己的位置信息，如果之后可以的话，可以做一个定位，直接获取信息）初始值为空
    Pnum int null                         #帖子数量（初始值为空，也就是0）
);



DROP TABLE IF EXISTS `Gather`;
#收藏信息表
create table Gather
(
    Gid int auto_increment primary key,	#收藏编号
    Uid int not null ,#用户编号
    Cid int null, #猫编号（可以为空，可以收藏帖子，帖子里面不包含猫猫信息），初始值为空
    Pid int null, #帖子编号（可以为空，可以收藏帖子，帖子里面不包含猫猫信息），初始值为空
    Gnum int null, #收藏数量（初始值为空，也就是0）
    Gtime date null, #收藏时间（这个可以用户点击进去，了解自己收藏详情的时候显示，如果Ptime发帖时间可以做的话，这个不知道是不是可以，我先放着）
    foreign key(Uid) references User(Uid), #猫编号作为外码
    foreign key(Cid) references Cat(Cid) #猫编号作为外码
);
