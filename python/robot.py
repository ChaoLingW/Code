import webbrowser
import random
import requests
import re
# 定义海报下载海报的函数
def download_dou_ban():
    url = 'https://movie.douban.com'
    # 1获取豆瓣电影网页的内容
    douban_response = requests.get(url)
    str_content = douban_response.content.decode('utf-8')
    # 2从网页内容中分离海报地址
    pattern = '<li class="ui-slide-item"  data-title=".*?<img src="(.*?)" alt="(.*?)" rel="nofollow" class="" />.*?<li class="rating">.*?<span class="subject-rate">(.*?)</span>'
    res = re.findall(pattern, str_content, re.S)
    # 3下载网络图片，并保存到本地
    #3.1 遍历访问网络图片地址，得到图片的内容
    cnt = 1
    for addr, name, score in res:
        response = requests.get(addr)
        #3.2 将图片的内容写入到本地文件中
        with open('img/{}.jpg'.format(cnt),'wb') as f:
            f.write(response.content)
        cnt += 1
    #返回，本次共下载了多少图片
    return cnt-1

def  str_compare_rate(str1,str2):
    rate_out = 0
    cnt_str1 = 0
    for i_str1 in  str1:
        cnt_i = 1 if i_str1 in str2 else 0
        cnt_str1 = cnt_str1 + cnt_i
    rate_out = 100 * cnt_str1 / (len(str1) + len(str2))
    return rate_out


list_dui_hua_rong = ['你好','你也好','天气如何','晴空万里','早上好','早上好哈','你是谁','你在逗我吗？居然不认识我','好累呀','听首歌休息一下','再见','我先走了，有事您叫我','回来','你的小可爱不在服务区','老李呢','他不让我告诉你','没事，你偷偷告诉我','好吧，老李裸奔去了！别说我说的']
list_command = ['退出','打开百度','打开新浪','下载电影海报','拼接网页']
list_not = ['让我想想','我好想没有听懂','这太难了','换句话试试','打开网页看看']

while True:
    str_zhen_ren = input('[~~~真人~~~]:')

    list_rate_dh = [str_compare_rate(str_zhen_ren, i_str_list) for i_str_list in list_dui_hua_rong]#存储输入的内容与对话之间的相似度
    list_rate_cmd = [str_compare_rate(str_zhen_ren, i_str_list) for i_str_list in list_command]  # 存储输入的内容与对话之间的相似度
    if max(list_rate_cmd) == 0 and max(list_rate_dh) == 0:
        print('[机器人助手]:{}'.format(list_not[random.randint(0,3)]))
    else:
        if max(list_rate_cmd) > max(list_rate_dh):
            #命令分支
            print('[机器人助手]:马上执行您的命令，请稍等')
            index_zhen_ren = list_rate_cmd.index(max(list_rate_cmd))
            if '退出' == list_command[index_zhen_ren]:
                break
            elif '打开百度' == list_command[index_zhen_ren]:
                webbrowser.open('www.baidu.com')
            elif '打开新浪' == list_command[index_zhen_ren]:
                webbrowser.open('www.sina.com.cn')
            elif '下载电影海报' == list_command[index_zhen_ren]:
                print('[机器人助理]:正在帮您下载')
                cnt_download = download_dou_ban()
                print('[机器人助理]:共帮您下载{}张海报，放在img文件夹中'.format(cnt_download))
            elif '拼个网页' == list_command[index_zhen_ren]:
                pass
            elif '打开网页看看' == list_command[index_zhen_ren]:

            else:
                pass
        else:
            # 对话分支
            index_zhen_ren = list_rate_dh.index(max(list_rate_dh))
            # if max(list_rate_dh) == 0:
            #     print('[机器人助手]:我好想没听 明白您在说什么')
            # else:
            str_robot = list_dui_hua_rong[(index_zhen_ren+1) % len(list_dui_hua_rong)]
            print('[机器人助手]:{}'.format(str_robot))
