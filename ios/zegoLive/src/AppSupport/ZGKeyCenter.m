//
//  ZGKeyCenter.m
//  LiveRoomPlayGround
//
//  Created by zego on 2019/7/2.
//  Copyright © 2019 Zego. All rights reserved.
//

#import "ZGKeyCenter.h"

@implementation ZGKeyCenter

 + (unsigned int)appID {
     return 2755316391;
 }
 
 // 从即构主页申请
 + (NSData *)appSign {
     Byte signKey[] = {0x86,0x18,0x17,0x25,0x9f,0x4b,0x90,0xcb,0x2c,0xa9,0x1c,0x35,0xfc,0xac,0xd6,0x4a,0x56,0x85,0xc1,0x76,0x59,0xeb,0xee,0x5f,0xfa,0x30,0x22,0xcd,0x27,0x00,0x2e,0xdb};
     NSData* sign = [NSData dataWithBytes:signKey length:32];
     return sign;
 }

@end
