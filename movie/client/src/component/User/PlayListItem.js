import React, { Component } from 'react';
import Function from '../../Function/Function'

class PlayListItem extends Component{

    formatDate(date){
        const index = date.indexOf('T');
        return date.substring(0, index);
    }

    render(){
        return(       
            <div className='PlayListItem'>
                <a href={'/video/v/' + this.props.item.id}>
                    <img alt='' src={this.props.item.snippet.thumbnails.medium.url}></img>
                </a>
                <div className='title-container'>
                    <a href={'/video/v/' + this.props.item.id} className='title'>{this.props.item.snippet.title}</a>
                </div>
                <div className='detail'>
                    <div className='detail-view'>
                        <i className='small material-icons detail-item view-icon'>play_circle_outline</i>
                        <span className='detail-item view'>{Function.formatNumber(this.props.item.statistics.viewCount)}</span>

                    </div>
                    <div className='detail-time'>
                        <i className='small material-icons detail-item time-icon'>access_time</i>
                        <span className='detail-item time'>{this.formatDate(this.props.item.snippet.publishedAt)}</span>
                    </div>
                </div>
            </div>
        );
    }
}