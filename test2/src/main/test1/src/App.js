import React, { useState } from 'react';
import axios from 'axios';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';

function App() {
  const [validated, setValidated] = useState(false);
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    confirmPassword: '',
    name: '',
    email: ''
  });

  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData({ ...formData, [id]: value });
  };

  const handleSubmit = (event) => {
    const form = event.currentTarget;
    event.preventDefault();
    event.stopPropagation();

    if (form.checkValidity() === false) {
      setValidated(true);
      return;
    }

    if (formData.password !== formData.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    axios.post('/axios/saveReg', {
      username: formData.username,
      password: formData.password,
      name: formData.name,
      email: formData.email
    })
    .then(response => {
      console.log(response.data);
      alert('Registration successful!');
    })
    .catch(error => {
      console.error('There was an error saving the member!', error);
    });
  };

  return (
    <div className="App">
      <Container className="mt-5">
        <Row className="justify-content-md-center">
          <Col md={6}>
            <h2 className="text-center">회원가입</h2>
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
              <Form.Group controlId="username">
                <Form.Label>아이디</Form.Label>
                <Form.Control
                  required
                  type="text"
                  placeholder="아이디를 입력하세요"
                  value={formData.username}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  올바른 아이디를 입력하세요.
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group controlId="password">
                <Form.Label>비밀번호</Form.Label>
                <Form.Control
                  required
                  type="password"
                  placeholder="비밀번호를 입력하세요"
                  minLength="6"
                  value={formData.password}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  최소 6자 이상의 비밀번호를 입력하세요.
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group controlId="confirmPassword">
                <Form.Label>비밀번호 확인</Form.Label>
                <Form.Control
                  required
                  type="password"
                  placeholder="비밀번호를 다시 입력하세요"
                  minLength="6"
                  value={formData.confirmPassword}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  비밀번호를 다시 확인하세요.
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group controlId="name">
                <Form.Label>이름</Form.Label>
                <Form.Control
                  required
                  type="text"
                  placeholder="이름을 입력하세요"
                  value={formData.name}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  이름을 입력하세요.
                </Form.Control.Feedback>
              </Form.Group>

              <Form.Group controlId="email">
                <Form.Label>이메일</Form.Label>
                <Form.Control
                  required
                  type="email"
                  placeholder="이메일을 입력하세요"
                  value={formData.email}
                  onChange={handleChange}
                />
                <Form.Control.Feedback type="invalid">
                  올바른 이메일 주소를 입력하세요.
                </Form.Control.Feedback>
              </Form.Group>

              <Button variant="primary" type="submit" className="w-100 mt-3">
                가입하기
              </Button>
            </Form>
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;