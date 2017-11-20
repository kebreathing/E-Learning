# Author: chris
# Email: kebreathing@gmail.com
# Date: 2017年11月18日

import csv
import os
import Exception
from collections import namedtuple

csv_path = 'F:/codes/java/stock data/'
csv_file = csv_path + 'sh600000.csv'
Stock = namedtuple('Stock', ['type', 'code', 'date', 'open', 'high', 'low', 'close', 'volume', 'money', 'earnings'])


def read_csv(fname):
    stocks = []
    try:
        with open(fname, newline='') as csvFile:
            data = csv.reader(csvFile, delimiter=',')
            for row in data:
                # Need to build a namedTuple
                if row[0] == 'code':
                    continue

                stock = Stock(type=row[0][0:2], code=row[0], date=row[1], open=row[2], high=row[3],
                              low=row[4], close=row[5], volume=row[7], money=row[8],
                              earnings=(float(row[5]) - float(row[2])))
                stocks.append(stock)
    except UnicodeDecodeError:
        print('{ %s } cannot read.', fname)

    # Remove the first row(Header): code, date, .... ,
    return stocks[:]


# 找到指定年份指定股票的最大利润值
def max_stock_with_code(code=None, year=None, month=None, stocks=None):
    if code is None:
        raise Exception.EmptyParametersError("code")
    if stocks is None:
        raise Exception.EmptyParametersError("stocks")

    max_earning = 0.0
    max_stock = []
    for stock in stocks:
        if year is not None and year != int(stock.date[0:4]):
            continue
        if month is not None and month != int(stock.date[5:7]):
            continue

        if max_earning < stock.earnings:
            max_earning = stock.earnings
            max_stock = stock

    return max_stock


# 把所有的股票信息全部读取出来，并保存在all_stocks中
def read_csv_patch(directory_path):
    all_stocks = []
    for parent, directories, files in os.walk(directory_path):
        for file in files:
            for stock in read_csv(parent + file):
                all_stocks.append(stock)

    return all_stocks


# 把股票信息全部存储在save_path中
def write_stocks_csv(save_path=None, all_stocks=None, desc=""):
    if save_path is None:
        raise Exception.EmptyParametersError('save_path')

    if all_stocks is None:
        raise Exception.EmptyParametersError('all_stocks')

    with open(save_path, 'w') as file:
        for stock in all_stocks:
            s = [item for item in stock]
            file.write(str(s) + '\n')

    print('%s: %d stocks has been written to {%s}.' % (desc, len(all_stocks), save_path))


# 找到所有股票中特定年月的股票
def stocks_of_date(year=None, month=None, date=None, all_stocks=None):
    if all_stocks is None:
        raise Exception.EmptyParametersError("all_stocks")

    stocks = []
    for stock in all_stocks:
        if year is not None and year != int(stock.date[0:4]):
            continue
        if month is not None and month != int(stock.date[5:7]):
            continue
        if date is not None and date != int(stock.date[8:]):
            continue
        stocks.append(stock)

    return stocks


# 找到特定年份特定类型的最大利润股票
def stocks_with_maxearning(type=None, year=None, all_stocks=None):
    if all_stocks is None:
        raise Exception.EmptyParametersError("all_stocks")

    max_earning = 0.0
    max_stock = []
    for stock in all_stocks:
        if type is not None and stock.type != type:
            continue
        if year is not None and int(stock.date[0:4]) != year:
            continue

        if max_earning < stock.earnings:
            max_earning = stock.earnings
            max_stock = stock

    return max_stock


# Homework
# 获得2013年4月的所有股票信息
def get_stocks_in_ym(directory_path=None, year=2013, month=4, save_path="./April_2013.csv"):
    if directory_path is None:
        raise Exception.EmptyParametersError("Directory Path")

    all_stocks = read_csv_patch(directory_path)
    stocks_in_april = stocks_of_date(year=year, month=month, all_stocks=all_stocks)
    write_stocks_csv(save_path, stocks_in_april, "Stocks in April 2013")


# 获得13、14年sh和sz的最大股票
def get_maxearning_in_yt(directory_path=None, save_path="./maxearnings.csv"):
    if directory_path is None:
        raise Exception.EmptyParametersError("Directory_path")

    all_stocks = read_csv_patch(directory_path)
    sh_2013 = stocks_with_maxearning('sh', 2013, all_stocks)
    sh_2014 = stocks_with_maxearning('sh', 2014, all_stocks)
    sz_2013 = stocks_with_maxearning('sz', 2013, all_stocks)
    sz_2014 = stocks_with_maxearning('sz', 2014, all_stocks)

    write_stocks_csv(save_path, [sh_2013, sh_2014, sz_2013, sz_2014], "Max Earning!")


# 获得一个股票的2013、2014最大股票
def get_max_of_a_stock(filepath=None, filename=None):
    if filepath is None:
        raise Exception.EmptyParametersError("Directory Path")

    stocks = read_csv(filepath)
    stock2013 = max_stock_with_code(code=filename[:-2], year=2013, stocks=stocks)
    stock2014 = max_stock_with_code(code=filename[:-2], year=2014, stocks=stocks)
    return [stock2013, stock2014]


# 获得所有股票的2013、2014最大股票
def get_max_of_all_stocks(directory_path, save_path="./stocks.csv"):
    if directory_path is None:
        raise Exception.EmptyParametersError("Directory Path")

    stocks_with_max = []
    for parent, dicts, files in os.walk(directory_path):
        for file in files:
            for stock in get_max_of_a_stock(parent + file, file):
                stocks_with_max.append(stock)

    write_stocks_csv(save_path, stocks_with_max, "All Stocks Max Earning.")


# get_stocks_in_ym(directory_path=csv_path)
# get_maxearning_in_yt(directory_path=csv_path)
get_max_of_all_stocks(directory_path=csv_path)
