import React, { Component } from 'react'

export default class Footer extends Component {
    constructor(props) {
        super(props)

        this.state = {
                
        }
    }
  
    render() {
    return (
        <footer className = "bg-gray-700 mx-auto p-4">
              <nav className="navbar navbar-expand-md navbar-dark bg-dark"></nav>
        <span className="text-muted">All Rights Reserved 2023</span>
    </footer>
    )
  }
}
