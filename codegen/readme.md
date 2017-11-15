#### 原codegen的工程地址：`git@gitlab.idcos.net:CloudJ/idcos-codegen.git`,clone 到本地后，

1. 把路径加到path中：

    - Mac：在.bash_rc（或者 .zsh_rc） 添加： `export IDCOS_CODEGEN_PATH="/Users/zhouqin/Code/idcos/idcos-enterprise-codegen"`
    - Windows: 环境变量添加？？

注意修改成你本地的路径地址。

2. 初始化ant.properties 

内容和之前的一样，样本：

```
project.dir=/Users/zhouqin/Code/idcos/hf-csa-manager
ember.dir=/Users/zhouqin/Code/hengfeng/hf-csa-web

[DEFAULT]
#database.url=jdbc:mysql://mysql.dev.idcos.net:3306/hf-csa
database.url=jdbc:mysql://mysql.dev.idcos.net:3306/hf-csa
database.user=root
#database.password=P@ssw0rd
database.password=yunjikeji
database.schema=hf-csa
database.catalog=
database.driver=com.mysql.jdbc.Driver
```

注意修改 `project.dir`  `ember.dir`  `database`

