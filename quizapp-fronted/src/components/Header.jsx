import React, { Component } from 'react'

export default class Header extends Component {
    constructor(props) {
        super(props)

        this.state = {
                
        }
    }
  
    render() {
    return (
        <div>
        <header className='bg-gray-700 mx-auto p-4'>
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
            <div className='text-white'>Employee Management App</div>
            </nav>
        </header>
    </div>
    )
  }
}
