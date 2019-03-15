import { FETCH_USER_PLAY_LIST } from '../action/types';

export default function(state = null, action){
	switch(action.type){
		default:
			return state;
		case FETCH_USER_PLAY_LIST:
			return action.payload || false;
	}
}