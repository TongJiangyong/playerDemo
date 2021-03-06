//
//  ZGSoundLevelTableViewCell.h
//  LiveRoomPlayground-iOS
//
//  Created by Paaatrick on 2019/9/4.
//  Copyright © 2019 Zego. All rights reserved.
//

#ifdef _Module_SoundLevel

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface ZGSoundLevelTableViewCell : UITableViewCell

@property (nonatomic, copy) NSString *streamID;
@property (nonatomic, copy) NSArray<NSNumber *> *spectrumList;
@property (nonatomic, copy) NSNumber *soundLevel;

@end

NS_ASSUME_NONNULL_END

#endif
