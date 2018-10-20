# Todo

标签（空格分隔）： grad-setup

---
# log in
目前已存在两个用户:
 * user id:1 password: 123
 * user id:2 password 123
**实现:**
密码正确顺利登入.登录后进入homepage,页面的header上的login register按钮变为log out.
**问题:**
目前都是happy path.没有密码错误等提示信息.

#register
**实现:**
用户注册.注册成功后会返回用户的user id,用于登录.
**问题:**
还没有对两次密码校验.

# home page
**实现:**
进入home page后可以点击login out退出登录.
**问题:**
页面刷新后丢失登录状态.


# page sort
**实现:**
可以进行每页item数量的选择,可以上一页下一页.点击表头字段,可以进行除status外的其他字段的升序或者降序排列.

#search
**实现:**
可以以dueDate status name进行搜索.点击search按钮展示结果.搜索栏收起后显示所有todo.
**问题:**
在搜索状态下点击排序,不是对已经搜索出来的todo做排序,而是对所有todo排序.

# statistic
**实现:**
在切换到statistics的tab会请求到所有todo数据,对其统计:根据status和dueDate.其中dueDate的统计分成五种: out of time,deadline,left one day, left two day,more than two day.
同样可以在统计tab中搜索,点击搜索按钮和展示结果,搜索栏收起后没显示所有数据的统计结果.




