//
//  AGJoinLiveViewController.h
//  LiveRoomPlayground-iOS
//
//  Created by zhanxiaochao on 2020/11/19.
//  Copyright © 2020 Zego. All rights reserved.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface AGJoinLiveViewController : UIViewController

// 房间的主播（创建着）ID
@property (nonatomic, copy) NSString *roomAnchorID;

// 房间 ID
@property (nonatomic, copy) NSString *roomID;

// 当前用户 ID
@property (nonatomic, copy) NSString *currentUserID;

@end

NS_ASSUME_NONNULL_END
