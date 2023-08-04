-- 创建库
create database if not exists yinggeapi;

-- 切换库
use yinggeapi;

-- 接口信息表
create table if not exists interface_info
(
    id             bigint auto_increment comment 'id' primary key,
    name           varchar(256)                       not null comment '接口名称',
    description    varchar(256)                       null comment '描述',
    url            varchar(512)                       not null comment '接口地址',
    `requestParams` text not null comment '请求参数',
    method         varchar(256)                       not null comment '请求类型',
    requestHeader  text                               null comment '请求头',
    responseHeader text                               null comment '响应头',
    status         int      default 0                 not null comment '接口状态 0-关闭 1-开启',
    userId         bigint                             not null comment '创建人',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
) comment '接口信息' collate = utf8mb4_unicode_ci;

INSERT INTO interface_info (name, description, url, method, requestHeader, responseHeader, status, userId, isDelete)
VALUES ('Interface1', 'Description for Interface1', 'http://localhost:8080/api/interface1', 'GET', NULL, NULL, 1, 1, 0),
       ('Interface2', 'Description for Interface2', 'http://localhost:8080/api/interface2', 'POST', NULL, NULL, 1, 1,
        0),
       ('Interface3', 'Description for Interface3', 'http://localhost:8080/api/interface3', 'GET', NULL, NULL, 0, 2, 0),
       ('Interface4', 'Description for Interface4', 'http://localhost:8080/api/interface4', 'PUT', NULL, NULL, 1, 2, 0),
       ('Interface5', 'Description for Interface5', 'http://localhost:8080/api/interface5', 'DELETE', NULL, NULL, 0, 3,
        0),
       ('Interface6', 'Description for Interface6', 'http://localhost:8080/api/interface6', 'GET', NULL, NULL, 1, 3, 0),
       ('Interface7', 'Description for Interface7', 'http://localhost:8080/api/interface7', 'POST', NULL, NULL, 0, 4,
        0),
       ('Interface8', 'Description for Interface8', 'http://localhost:8080/api/interface8', 'GET', NULL, NULL, 1, 4, 0),
       ('Interface9', 'Description for Interface9', 'http://localhost:8080/api/interface9', 'PUT', NULL, NULL, 0, 5, 0),
       ('Interface10', 'Description for Interface10', 'http://localhost:8080/api/interface10', 'DELETE', NULL, NULL, 1,
        5, 0),
       ('Interface11', 'Description for Interface11', 'http://localhost:8080/api/interface11', 'GET', NULL, NULL, 0, 1,
        0),
       ('Interface12', 'Description for Interface12', 'http://localhost:8080/api/interface12', 'POST', NULL, NULL, 1, 1,
        0),
       ('Interface13', 'Description for Interface13', 'http://localhost:8080/api/interface13', 'GET', NULL, NULL, 0, 2,
        0),
       ('Interface14', 'Description for Interface14', 'http://localhost:8080/api/interface14', 'PUT', NULL, NULL, 1, 2,
        0),
       ('Interface15', 'Description for Interface15', 'http://localhost:8080/api/interface15', 'DELETE', NULL, NULL, 0,
        3, 0),
       ('Interface16', 'Description for Interface16', 'http://localhost:8080/api/interface16', 'GET', NULL, NULL, 1, 3,
        0),
       ('Interface17', 'Description for Interface17', 'http://localhost:8080/api/interface17', 'POST', NULL, NULL, 0, 4,
        0),
       ('Interface18', 'Description for Interface18', 'http://localhost:8080/api/interface18', 'GET', NULL, NULL, 1, 4,
        0),
       ('Interface19', 'Description for Interface19', 'http://localhost:8080/api/interface19', 'PUT', NULL, NULL, 0, 5,
        0),
       ('Interface20', 'Description for Interface20', 'http://localhost:8080/api/interface20', 'DELETE', NULL, NULL, 1,
        5, 0);

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    unionId      varchar(256)                           null comment '微信开放平台id',
    mpOpenId     varchar(256)                           null comment '公众号openId',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    accessKey  varchar(512)                           null comment 'accessKey',
    secretKey  varchar(512)                           null comment 'secretKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    index idx_unionId (unionId)
) comment '用户' collate = utf8mb4_unicode_ci;

-- 用户接口关系表
create table if not exists user_interface_info
(
    id             bigint auto_increment comment 'id' primary key,
    userId         bigint                             not null comment '调用用户 id',
    interfaceInfoId bigint                             not null comment '被调用接口 id',
    totalNum        int      default 0                 not null comment '总调用次数',
    leftNum       int      default 0                 not null comment '剩余调用次数',
    status         int      default 0                 not null comment '状态 0-正常 1-禁用',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除'
) comment '用户接口关系表' collate = utf8mb4_unicode_ci;