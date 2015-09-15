# coding=utf-8
import MySQLdb

__author__ = 'ligson'
videoRoot = "/"
user = "root"
password = "bfrootpassword"
host = "192.168.1.201"
port = 3306
db = "conv"

try:
    conn = MySQLdb.connect(host=host, user=user, passwd=password, db=db, port=port)
    cur = conn.cursor()
    cur.execute('select * from boful_file')
    cur.close()
    conn.close()
except MySQLdb.Error, e:
    print "Mysql Error %d: %s" % (e.args[0], e.args[1])

