#TIP35：注解优先于命名模式
##什么叫命名模式？
比如之前Java单元测试用例，要求方法名都要test打头，这种就是使用命名模式来区分是否是测试用例方法，以此来判断是否执行测试。
##命名模式和注解
1、命名模式对名称要求严格，但又无保障措施，一旦开发人员test打错了，就无法执行测试。
采用注解，IDE会帮助你做这部分工作。
2、命名模式无法传递参数，注解可以通过value等方法传递参数。
##代码说明
1、第一个例子：RunTests演示如何使用注解
2、第二个例子：ExceptionRunTest演示如何传递参数
3、第三个例子：ExceptionRunTest2是对ExceptionRunTest的优化，如何传递参数数组
##知识点
1、如何使用注解
2、反射如何调用静态方法