//
//  AGJoinLiveViewController.m
//  LiveRoomPlayground-iOS
//
//  Created by zhanxiaochao on 2020/11/19.
//  Copyright © 2020 Zego. All rights reserved.
//

#import "AGJoinLiveViewController.h"
#import <AgoraMediaPlayer/AgoraMediaPlayer.h>
#import <AgoraRtcEngineKit/AgoraRtcEngineKit.h>
@interface AGJoinLiveViewController()<AgoraMediaPlayerDelegate>
@property (nonatomic, strong) AgoraMediaPlayer *player;
@property (nonatomic, strong) AgoraRtcEngineKit *agoraKit;
@property (weak, nonatomic) IBOutlet UIView *containerView;



@end
@implementation AGJoinLiveViewController



-(void)viewDidLoad
{
    [super viewDidLoad];
    _player = [[AgoraMediaPlayer alloc] initWithDelegate:self];
    [_player setView:self.containerView];
    self.navigationItem.leftBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"退出" style:UIBarButtonItemStylePlain target:self action:@selector(closePage:)];

}
- (IBAction)open:(id)sender {
    [_player open:@"http://114.236.93.153:8080/download/video/15songs.mp4" startPos:0];
}
- (IBAction)play:(id)sender {
    [_player play];
}
- (IBAction)stop:(id)sender {
    [_player stop];
}
-(void)viewDidDisappear:(BOOL)animated
{
    [super viewDidDisappear:animated];

    
}
- (void)closePage:(id)sender {
    
    [self exitCurrentViewController];
}
- (void)exitCurrentViewController
{
    
    [_player destroy];
    _player = NULL;
    [self dismissViewControllerAnimated:YES completion:nil];
}

/** Reports the playback state change.

 @param playerKit AgoraMediaPlayer

 @param state The new playback state after change. See AgoraMediaPlayerState.

 @param error The player's error code. See AgoraMediaPlayerError.
 */
- (void)AgoraMediaPlayer:(AgoraMediaPlayer *_Nonnull)playerKit
       didChangedToState:(AgoraMediaPlayerState)state
                   error:(AgoraMediaPlayerError)error
{
    
    
    
    
}
@end
