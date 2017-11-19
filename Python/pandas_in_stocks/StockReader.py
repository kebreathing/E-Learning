# Author: chris
# Email: kebreathing@gmail.com
# Date: 2017年11月18日

import csv
import os
from collections import namedtuple

csv_path = "/Users/chris/Downloads/data/stock data/"
csv_file = csv_path + "sh600000.csv"
Stock = namedtuple('Stock', ['code', 'date', 'open', 'high', 'low', 'close', 'volume', 'money', 'earnings'])


def read_csv(fname):
    stocks = []
    try:
        with open(fname, newline='') as csvFile:
            data = csv.reader(csvFile, delimiter=',')
            for row in data:
                # Need to build a namedTuple
                if row[0] == 'code':
                    continue

                stock = Stock(code=row[0], date=row[1], open=row[2], high=row[3],
                              low=row[4], close=row[5], volume=row[7], money=row[8],
                              earnings=(float(row[5])-float(row[2])))
                stocks.append(stock)
    except UnicodeDecodeError:
        print('{ %s } cannot read.', fname)

    # Remove the first row(Header): code, date, .... ,
    return stocks[:]


def read_csv_patch(dname):
    # 建立字典，分别存储
    dict = {}
    for parent, dirnames, filenames in os.walk(dname):
        # parent: the path of directory
        # dirnames: the subdirectories of the current directory
        # filenames: the files of the current directory
        print('There are %d csv files in %s' % (len(filenames),parent))
        for filename in filenames:
            code = filename[:-4]
            type = filename[:2]
            csvpath = parent + filename
            if type not in dict:
                dict[type] = []

            # 分类型存储数据
            dict[type].append({code: read_csv(csvpath)})

    # 简要输出结果
    print('There are %d csv files about sh.' % (len(dict['sh'])))
    print('There are %d csv files about sz.' % (len(dict['sz'])))
    return dict


def stocks_in_month_year_code(code=None, year=None, month=None, dict=None):
    stock_in_month_year = []
    if dict is None:
        return []

    for key in dict.keys():
        # 按类型获取股票
        for stocks in dict[key]:
            # csv 文件内的股票信息
            for stock_code in stocks.keys():
                # stock 的代码编号
                for stock in stocks[stock_code]:
                    if code is not None and code != stock['code']:
                        continue
                    if year is not None and int(stock.date[0:4]) != year:
                        continue
                    if month is not None and int(stock.date[5:7]) != month:
                        continue

                    stock_in_month_year.append(stock)

    print("Here are %d rows of stocks in %d-%d" % (len(stock_in_month_year), year, month))
    return stock_in_month_year


def maxearnings_in_year_month(code=None, year=None, month=None, stocks=None):
    if code is None:
        return

    if stocks is None:
        return




dict = read_csv_patch(csv_path)
stocks_in_month_year_code(year=2014, month=4, dict=dict)