import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../../action';

var MovieTabStyle = {
    marginTop: '1px',
}

class TopicTab extends Component {
    onChangeTab(event) {
        this.props.updateTab(event);
        window.location.href = this.props.tabList[event].link;
    }

    getVideoId(routerName) {
        const index = routerName.indexOf('/');
        if (index === -1)
            return '';

        const start = index + 1;
        const end = routerName.indexOf('/', start);
        if (end === -1) {
            return routerName.substring(start, routerName.length);
        } else {
            return routerName.substring(start, end);
        }
    }

    getRouterIndex() {
        const router = this.getVideoId(this.props.location.pathname);
        if (router === '') {
            return 0;
        } else {
            for (let i = 0; i < this.props.tabList.length; ++i) {
                const name = (this.props.tabList[i].name).toLocaleLowerCase();
                if (name === router)
                    return i;
            }
        }
    }

    render() {
        const index = this.getRouterIndex();
        return (
            <div className="row" style={MovieTabStyle}>
                <div className="col s12">
                    <ul className="tabs tab-demo z-depth-1">
                        {

                            this.props.tabList.map((tabInfo, i) => {
                                return (
                                    <li onClick={this.onChangeTab.bind(this, i)} key={i} className="tab col s3"><a className={i === index ? 'active' : ''} href={tabInfo.link}>{tabInfo.name}</a></li>
                                );
                            })
                        }
                    </ul>
                </div>
            </div>
        );
    }
}

function mapStateToProps({ tab }) {
    return { tab };
}

export default connect(mapStateToProps, actions)(TopicTab);