# Redis 如何做到禁止一些危险命令
## 生产环境不能使用的危险的命令有
- Keys *
    虽然其模糊匹配功能使用非常方便， 在小数据量情况下使用没有什么问题， 但是当数据量大时就会导致Redis锁住及CPU飙升， 
    所在在生产环境建议禁用或重命名处理。 
  
- flushdb
    删除Redis中当前所有数据库中的所有记录， 并且此命令从不会执行失败
  
- flushall
    删除Redis中所有数据库中的所有记录， 不只是当前所有数据库，并且此命令从不会执行失败。 
    
- config
    客户端可以修改Redis的配置。 
    
以上命令都是建议在生产环境进行禁用，或进行命令名处理。 

## 禁用高危命令
方法是，添加 
- rename-command KEYS "" 或 
- rename-command KEYS "asdflkjlk234234lkjasdlkfj" 重命名

注意：

如果把FlushALL 命令也进行了禁用或重命令， 需要设置配置文件中 
- appendonly no  配置是否进行持久化处理
否则会服务无法启动。 

验证操作。 
