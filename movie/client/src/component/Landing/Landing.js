import React, { Component } from 'react';
import { Route, Redirect, Switch } from 'react-router-dom';
import { connect } from 'react-redux';
import * as actions from '../../action';
import TopicTab from './TopicTab';
import Game from './Topic/Game';
import Movie from './Topic/Movie';
import Home from './Topic/Home';
import TV from './Topic/TV';
import Music from './Topic/Music';
import Dance from './Topic/Dance';
import Technology from './Topic/Technology';
import Life from './Topic/Life';
import Yoo from './Topic/Yoo';
import Anime from './Topic/Anime';

class Landing extends Component {
    constructor(props) {
        super(props);

        this.state = {
            tabList: [
                { name: 'Home', link: '/' },
                { name: 'Otomad', link: '/otomad' },
                { name: 'Anime', link: '/anime' },
                { name: 'Game', link: '/game' },
                { name: 'Music', link: '/music' },
                { name: 'Dance', link: '/dance' },
                { name: 'Technology', link: '/technology' },
                { name: 'Life', link: '/life' },
                { name: 'Movie', link: '/movie' },
                { name: 'TV', link: '/tv' }
            ]
        }
    }

    

    getVideoId(routerName){
        const index = routerName.indexOf('/');
        if (index === -1)
            return '';

        const start = index + 1;
        const end = routerName.indexOf('/', start);
        if (end === -1){
            return routerName.substring(start, routerName.length);
        }else{
            return routerName.substring(start, end);
        }
    }

    render() {
        return (
            <div className='Landing' >
                <TopicTab tabList={this.state.tabList} location={this.props.location} />
                <Switch>
                    <Route exact path="/" component={Home} />
                    <Route exact path="/tv" component={TV} />
                    <Route exact path="/music" component={Music} />
                    <Route exact path="/dance" component={Dance} />
                    <Route exact path="/technology" component={Technology} />
                    <Route exact path="/life" component={Life} />
                    <Route exact path="/otomad" component={Yoo} />
                    <Route exact path="/game" component={Game} />
                    <Route exact path="/movie" component={Movie} />
                    <Route exact path="/anime" component={Anime} />
                    <Redirect from='*' to='/404' />
                </Switch>
            </div>
        );
    }
}

function mapStateToProps({movies}){
	return { movies };
}

export default connect(mapStateToProps, actions)(Landing);