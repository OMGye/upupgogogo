1.登入用户
/user/login.do
request
userName,password

response
fail

{
    "status": 1,
    "msg": "账号或密码错误"
}
{
  "status": 1,
  "msg": "账号未激活"
}
success
{
  "status": 0,
  "data": {
    "userId": 1,
    "userName": "王文超",
    "password": "147258",
    "phone": "15927287429",
    "state": 1,
    "userType": 0,
    "itemId": null,
    "createTime": 1532879000000,
    "lastEditTime": 1532887169000,
    "userImg": "111"
  }
}

2.管理员添加用户
/user/adduser.do
request
userName,password,phone,userType(
    这里的级别就是,通过下拉列表传过来int参数
    BOSS(0,"老板"),
    MANAGER(1,"项目经理"),
    FINANCIAL(2,"公司财务管理员"),
    ACCOUNT_UPLOAD(3,"记账员"),
    ACCOUNT_CHECKED(4,"财务审核员"),
    MATERIAL_UPLOAD(5,"材料员"),
    MATERIAL_CHECKED(6,"材料审核员"),
    EMPLOYEE(7,"普通员工");
)，
img（
   <form name="form1" action="/project/user/adduser.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc上传文件" />
  </form>
）

response
fail

{
    "status": 10,
    "msg": "需要登入管理员账户"
}
{
  "status": 1,
  "msg": "操作失败"
}

success
{
	"status": 0,
     "msg": "操作成功"
}

3.显示激活用户列表
/user/listableuser.do
request null

response
fail
{
    "status": 10,
    "msg": "需要登入管理员账户"
}
success
{
status: 0,
data: [
  {
userId: 1,
userName: "王文超",
password: "147258",
phone: "15927287429",
state: 1,
userType: 0,
itemId: null,
createTime: 1532879000000,
lastEditTime: 1532879005000,
userImg: "111"
   },
   {
userId: 2,
userName: "test",
password: "147258",
phone: "15927287429",
state: 1,
userType: 1,
itemId: null,
createTime: null,
lastEditTime: null,
userImg: "http://img.upupgogogo.cn/4561d912-ce12-438b-acee-5241d25c9b40.JPG"
  }
      ]
}

 4.显示未激活用户列表
/user/listunableuser.do
request null

response
fail
{
    "status": 10,
    "msg": "需要登入管理员账户"
}

success
{
status: 0,
data: [
  {
userId: 1,
userName: "王文超",
password: "147258",
phone: "15927287429",
state: 0,
userType: 0,
itemId: null,
createTime: 1532879000000,
lastEditTime: 1532879005000,
userImg: "111"
   },
   {
userId: 2,
userName: "test",
password: "147258",
phone: "15927287429",
state: 0,
userType: 1,
itemId: null,
createTime: null,
lastEditTime: null,
userImg: "http://img.upupgogogo.cn/4561d912-ce12-438b-acee-5241d25c9b40.JPG"
  }
      ]
}

5.修改用户权限（删除用户//也就是修改状态）
/user/updateuser.do
request state (userType)

response
fail
{
    "status": 10,
    "msg": "需要登入管理员账户"
}

{
    "status": 1,
    "msg": "操作失败"
}
success
{
    "status": 0,
    "msg": "操作成功"
}