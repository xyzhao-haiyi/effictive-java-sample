#TIP32:使用EnumSet代替位域
EnumSet实现上是使用位向量实现，简洁高效。
##什么是位向量
什么是位向量呢？就是用一个位表示一个元素的状态，用一组位表示一个集合的状态，每个位对应一个元素，而状态只可能有两种
##例子场景
想象一个场景，在一些工作中，比如医生、客服，不是每个工作人员每天都在的，每个人可工作的时间是不一样的，比如张三可能是周一和周三，李四可能是周四和周六，给定每个人可工作的时间，我们可能有一些问题需要回答，比如：
    有没有哪天一个人都不会来？
    有哪些天至少会有一个人来？
    有哪些天至少会有两个人来？
    有哪些天所有人都会来，以便开会？
    哪些人周一和周二都会来？ 
