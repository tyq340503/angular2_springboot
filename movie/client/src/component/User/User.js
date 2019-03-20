import './User.css';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../../action';
import queryString from 'query-string';
import Redirect from 'react-router-dom/Redirect';
import userTopImg from '../../assert/user_top.jpg';
import PlayListItem from './PlayList';

class User extends Component {

    componentDidMount(){
        const res = queryString.parse(this.props.location.search);

        if (res.id)
            this.props.fetchUserPlayList(res.id);
        else{
            window.location.href = "/404";
        }
    }

    render() {
        if (this.props.userPlayList === false){
            return  (<Redirect to='/404' />);
        }else if(this.props.userPlayList == null){
            return (<div className='user-middle-element user-center-element'><span>Loading......</span></div>);

        }else{
            document.title = this.props.userPlayList.channel.items[0].snippet.title + "'s space - CT Go";
            return (
                <div className='User'>
                    <div className='UserTop'>
                        <img draggable="false" className='background none-selected' alt='' src={userTopImg}></img>
                        <img className='head none-selected' alt='' src={this.props.userPlayList.channel.items[0].snippet.thumbnails.default.url}></img>
                        <span className='title'>{this.props.userPlayList.channel.items[0].snippet.title}</span>
                        <button className='sub btn'>substribe</button>
                    </div>
                    <div className='UserContent'>
                        {this.props.userPlayList.playlists.items.map((item, i) => {
                            return (
                                <PlayListItem key={i} title={item.snippet.title} item={item}/>
                            );
                        })}
                    </div>
                </div>
            );
        }
    }
}

function mapStateToProps({userPlayList}){
    return { userPlayList };
}

export default connect(mapStateToProps, actions)(User);