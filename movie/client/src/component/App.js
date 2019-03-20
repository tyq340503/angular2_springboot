import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { connect } from 'react-redux';
import * as actions from '../action';
import Landing from './Landing/Landing';
import Header from './Header/Header';
import Footer from './Footer/Footer';
import Video from './Video/Video';
import SearchMain from './Search/SearchMain';
import User from './User/User';
import NotFoundPage from './NotFoundPage';

class App extends Component {
	componentDidMount(){
		this.props.fetchUser();
	}

  	render() {
    	return (
      		<div >
      			<BrowserRouter>
              		<div>
                		<Header />
        				<div className="container">
						<Switch>
							<Route exact path="/search" component={SearchMain} />
							<Route exact path="/404" component={NotFoundPage} />
							<Route exact path="/user" component={User} />
							<Route path="/video/v/" component={Video} />
							<Route path="/" component={Landing} />
							<Route exact path="/surveys" component={Dashboard} />
							<Route exact path="/surveys/new" component={SurveyNew} />
						</Switch>
        				</div>
						<Footer />
              		</div>
      			</BrowserRouter>
      		</div>
    	);
  	}
}


export default connect(null, actions)(App);