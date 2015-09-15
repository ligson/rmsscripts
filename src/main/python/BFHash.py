# coding=utf-8
import hashlib
import os
import sys


def intToBytes(value):
    buf2 = []
    buf2.append(value >> 56 & 0xFF)
    buf2.append(value >> 48 & 0xFF)
    buf2.append(value >> 40 & 0xFF)
    buf2.append(value >> 32 & 0xFF)
    buf2.append(value >> 24 & 0xFF)
    buf2.append(value >> 16 & 0xFF)
    buf2.append(value >> 8 & 0xFF)
    buf2.append(value & 0xFF)
    return buf2


def getHexHash(filePath):
    fileName = filePath
    fp = open(fileName, "rb")
    fileSize = os.path.getsize(fileName)
    buf = bytearray(intToBytes(fileSize))
    if fileSize < 1024:
        #小于1024字节全部做hash
        buf = buf + bytearray(fp.read())
    else:
        #大于1024取文件首、中、尾的16个字节做hash
        #头部
        buf = buf + bytearray(fp.read(16))

        #中间
        fp.seek(fileSize / 2)
        buf = buf + bytearray(fp.read(16))

        #尾部
        fp.seek(fileSize - 1 - 16)
        buf = buf + bytearray(fp.read(16))

    fp.close()

    md = hashlib.md5()
    md.update(buf)
    return md.hexdigest().upper()


if __name__ == '__main__':
    print getHexHash(sys.argv[1])






