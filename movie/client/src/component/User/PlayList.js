import './PlayList.css'
import React, { Component } from 'react';
import {Row,Col} from 'react-materialize';
import PlayListItem from './PlayListItem';
import axios from 'axios';

class PlayList extends Component{
    constructor(props){
        super(props);

        this.state = {
            items: null
        }
    }

    componentWillMount(){
        this.fetchPlayListItems();
    }

    async fetchPlayListItems(){
        const res = await axios.post('/api/user_play_list_item', {id:this.props.item.id, number:8});
        //console.log(res);
        this.setState({items:res.data.items});
    }

    renderItems(){
        if (!this.state.items){
            return (<div className='user-middle-element user-center-element'><span>Loading......</span></div>);
        }else{
            return (
                this.state.items.map((item, i) => {
                    if (item.snippet.thumbnails){
                        return (
                            <Col key={i}><PlayListItem item={item}/></Col>
                        );
                    }else{
                        return (
                            <div key={i}></div>
                        );
                    }
                })
            );
        }
    }

    render(){
        
        <div className='PlayList'>
        
            <div className='PlayListTop'>
            <span className='PlayListTitle'>{this.props.title}</span>
            </div>
            <div className='PlayListContent'>
            <Row>
            {   
                this.renderItems()
            }
            </Row>
          
            
            </div>
        </div>
    }
}