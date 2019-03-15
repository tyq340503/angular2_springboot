import { combineReducers } from 'redux';
import authReducer from './authReducer';
import moviesReducer from './moviesReducer';
import tabReducer from './tabReducer';
import videoReducer from './videoReducer';
import barrageReducer from './barrageReducer';
import reviewReducer from './reviewReducer';
import relatedVideosReducer from './relatedVideosReducer';
import searchVideoReducer from './searchVideoReducer';
import userPlaylistReducer from './userPlaylistReducer';

export default combineReducers({
    auth : authReducer,
    userPlayList: userPlaylistReducer
})