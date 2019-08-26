import React, { Component } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

class Edit extends Component {

  constructor(props) {
    super(props);
    this.state = {
      contact: {}
    };
  }

  componentDidMount() {
    axios.get('http://localhost:8080/congregants/'+this.props.match.params.id)
      .then(res => {
        this.setState({ contact: res.data });
        console.log(this.state.contact);
      });
  }

  onChange = (e) => {
    const state = this.state.contact
    state[e.target.name] = e.target.value;
    this.setState({contact:state});
  }

  onSubmit = (e) => {
    e.preventDefault();

    const {name,first_last_name,second_last_name, address, birthday,phone,email,gender,civil_status,type,baptized} = this.state.contact;

    axios.put('http://localhost:8080/congregants/'+this.props.match.params.id, 
    { name,first_last_name,second_last_name, address, birthday,phone,email,gender,civil_status,type,baptized})
      .then((result) => {
        this.props.history.push("/show/"+this.props.match.params.id)
      });
  }

  render() {
    return (
      <div className="container">
        <div className="panel panel-default">
          <div className="panel-heading">
            <h3 className="panel-title">
              EDIT Congregant
            </h3>
          </div>
          <div className="panel-body">
            <h4><Link to={`/show/${this.state.contact.id}`}><span className="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Contact List</Link></h4>
            <form onSubmit={this.onSubmit}>
              <div className="form-group">
                <label for="name">Name:</label>
                <input type="text" className="form-control" name="name" 
                value={this.state.contact.name} onChange={this.onChange} placeholder="Name" />
              </div>
              <div className="form-group">
                <label for="name">First Last Name:</label>
                <input type="text" className="form-control" name="first_last_name" 
                value={this.state.contact.first_last_name} onChange={this.onChange} placeholder="First Last Name" />
              </div>
              <div className="form-group">
                <label for="name">Second Last Name:</label>
                <input type="text" className="form-control" name="first_last_name" 
                value={this.state.contact.second_last_name} onChange={this.onChange} placeholder="Second Last Name" />
              </div>
              <div className="form-group">
                <label for="title">Address:</label>
                <input type="text" className="form-control" name="address" 
                value={this.state.contact.address} onChange={this.onChange} placeholder="Address" />
              </div>
              <div className="form-group">
                <label for="author">Birthay:</label>
                <input type="text" className="form-control" name="birthday" 
                value={this.state.contact.birthday} onChange={this.onChange} placeholder="City" />
              </div>
              <div className="form-group">
                <label for="published_date">Phone Number:</label>
                <input type="text" className="form-control" name="phone" 
                value={this.state.contact.phone} onChange={this.onChange} placeholder="Phone Number" />
              </div>
              <div className="form-group">
                <label for="description">Email:</label>
                <input type="email" className="form-control" name="email" 
                value={this.state.contact.email} onChange={this.onChange} placeholder="Email Address" />
              </div>
                            <div className="form-group">
                <label for="description">Gender:</label>
                <input type="text" className="form-control" name="gender" 
                value={this.state.contact.gender} onChange={this.onChange} placeholder="Email Address" />
              </div>
                            <div className="form-group">
                <label for="description">Civil Status:</label>
                <input type="text" className="form-control" name="civil_status" 
                value={this.state.contact.civil_status} onChange={this.onChange} placeholder="Email Address" />
              </div>
                             <div className="form-group">
                <label for="description">Type:</label>
                <input type="text" className="form-control" name="type" 
                value={this.state.contact.type} onChange={this.onChange} placeholder="Email Address" />
              </div>
                            <div className="form-group">
                <label for="description">Baptized:</label>
                <input type="text" className="form-control" name="baptized" 
                value={this.state.contact.baptized} onChange={this.onChange} placeholder="Email Address" />
              </div>
              <button type="submit" className="btn btn-success">Update</button>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default Edit;
