 1.项目列表
 /item/itemlist.do
 request null（直接从session中取id）

 response
 fail
 {
    "status": 1,
    "msg": "用户权限不够"
 }
 fail
 {
    "status": 1,
    "msg": "当前项目为空"
 }

 success
 {  
    "status": 0,
    "data": [
       {
        "itemId":1,
        "itemName": "xxx"， 
        }
                ]
 }

 2.项目详情
  /item/itemdetail.do
  request itemId

  response
  fail 
  {
    "status": 1,
    "msg": "用户权限不够"
  }
   fail 
  {
    "status": 1,
    "msg": "没有找到该项目"
  }
  success
 {
  "status": 0,
  "data": {
    项目信息
    项目财务总信息
    项目材料总信息
  }
}

3.项目最新材料流水
/item/itemnewmaterial.do
  request itemId
 response
  fail 
  {
    "status": 1,
    "msg": "用户权限不够"
  }
   fail 
  {
    "status": 1,
    "msg": "没有找到该项目"
  }

  success
 {
  "status": 0,
  "data": {
    最新五条材料流水信息
  }
}

4.项目最新财务流水
/item/itemnewaccount.do
  request itemId
 response
  fail 
  {
    "status": 1,
    "msg": "用户权限不够"
  }
   fail 
  {
    "status": 1,
    "msg": "没有找到该项目"
  }

  success
 {
  "status": 0,
  "data": {
    最新五条财务流水信息
  }
}
5.修改项目经理
/item/itemchangeowner.do
 request itemId,userId
 response
  fail 
  {
    "status": 1,
    "msg": "用户权限不够"
  }
   fail 
  {
    "status": 1,
    "msg": "没有找到该项目或者未找到该用户"
  }

  success
 {
  "status": 0,
  "data": "修改成功"
}
6.修改其他人（记账员，审查员等四个人）
 request itemId,userId，（第一步先把用户表之前该项目的这个负责人取消，然后把该权限赋值给当前userId）
  fail 
  {
    "status": 1,
    "msg": "用户权限不够"
  }
   fail 
  {
    "status": 1,
    "msg": "没有找到该项目或者未找到该用户"
  }

  success
 {
  "status": 0,
  "data": "修改成功"
}
7.新建项目
request 