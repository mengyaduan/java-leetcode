## 优点
1. 当创建新的对象实例较为复杂时，使用原型模式可以简化对象的创建过程，通过复制一个已有实例可以提高新实例的创建效率
2. 扩展性较好：增减具体原型类的数量不需要客户端感知，但是要修改原型manager
3. 无需工厂类，结构简化
4. 可以通过深拷贝来记录对象的状态，例如做某一时刻的快照

## 缺点
1. 需要为每个类配备一个克隆方法。如果类调整的时候，可能需要修改clone方法，此时可能违背开闭原则 
2. 深拷贝的时候可能存在嵌套。同时每一层的对象都必须支持深拷贝，实现比较复杂

## 适用场景
- 创建新对象成本高。
- 如果要保存对象状态是，可以通过原型模式实现
- 需要避免使用分层次的工厂类来创建分层次的对象，并且类的实例对象只有一个或很少的几个组合状态。通过复制原型对象得到新实例可能比使用构造函数创建一个新实例更加方便

## 实现过程
### 浅拷贝
具体的实现类需要实现Cloneable接口，然后在clone方法中调用super.clone()进行Object的复制即可

### 深拷贝
通过序列化方式实现，将已有对象写入到流中；然后再读出来。