[原文传送门](http://blog.csdn.net/afei__/article/details/51476529)
 git remote -v                                          查看该代码pull的地方
 git config --list                                      git的配置信息
git config --global user.name "bukas"                   这是自己git的username
git config --global user.email "bukas@gmail.com"        自己git的email
使用Git bash，使用cd命令行进入你需要建立repository的地方，输入git init 
（这样就创建了一个被git管理的目录）

####一个提交检查的小流程

自己本机可以看的目录就是工作区，.git是版本库，里面的stage（或者index）就是暂存区。master是git自动创建的一个分支。
**touch readme.md**&emsp;&emsp;创建一个readme.md在该目录下（可以不用这一步，自己在仓库中建）
**git add readme.md**&emsp;&emsp;将readme.md放到暂存区（如果新建了一个文件，不add就不会被追踪）
**git add .**添加当前目录所有文件
**git commit -m "xxx"**&emsp;&emsp;    将暂存区内容提交到当前分支（还在工作区里）。-m就是command，里面写自己提交时修改信息。
**git status**&emsp;&emsp;列出当前目录所有还没有被git管理的文件和被git管理且被修改但还未提交(git commit)的文件，显示"changes not staged for commit:"后面是没有添加到暂存区的文件名称。显示"changes to be committed："后面是add后没有commit的文件。"untracked files"没有被追踪的文件。
**git status -uno**&emsp;&emsp;跟git status的区别就是不列出没有被追踪的文件
**git diff readme.md**&emsp;&emsp;查看这个文件跟之前有什么区别
**git diff**&emsp;&emsp;直接显示所有被追踪的文件的改动，从上到下是按照文件创建的先后顺序显示不同的地方。
**git log**&emsp;&emsp;可以看到每一次commit，从上到下是最新到最久
**git log --pretty==oneline**&emsp;&emsp;就是所有log信息一行一行的显示
注意：前面一大串是指commit id，HEAD是指当前版本。
#####当add错误的时候：
首先用git status看哪些文件add了
然后使用git reset HEAD就是把所有add的文件撤销了
git reset HEAD xxx.md就是把这个文件的add撤销了
#####当commit错误的时候：
**git reset --hard HEAD^**&emsp;&emsp;回退到上一个版本，HEAD^^回退到上两个版本；HEAD~100回退到之前100个版本的时候。回退完成之后会提示你现在在某某版本，那个id号也是commit id吧。这时候git log就会显示到这个版本的所有commit，可以输入git reflog，查看所有的commit和reset，每一行前面的编号都是该状态的commit id。
**git checkout -- readme.md**就是撤销该文件的修改

 **git remote add wangwj https://github.com/wangwenj/android_study.git**
 添加一个新的远程仓库，并且把远程仓库重命名为xxx

**git push -u wangwj master**  
**git config user.name "wangwj"**
**git config user.email "wangwj_hnu@163.com"**
**git pull <远程主机名> <远程分支名>:<本地分支名>**

问题：
checkout
reset
reset --hard