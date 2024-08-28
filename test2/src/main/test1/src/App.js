import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';

function InputField({ id, label, type, value, handleChange, feedback, required = true }) {
  return (
    <Form.Group controlId={id}>
      <Form.Label>{label}</Form.Label>
      <Form.Control
        required={required}
        type={type}
        placeholder={`${label}를 입력하세요`}
        value={value}
        onChange={handleChange}
      />
      <Form.Control.Feedback type="invalid">{feedback}</Form.Control.Feedback>
    </Form.Group>
  );
}

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
    event.preventDefault();
    event.stopPropagation();

    const form = event.currentTarget;
    if (form.checkValidity() === false || formData.password !== formData.confirmPassword) {
      setValidated(true);
      if (formData.password !== formData.confirmPassword) {
        alert("Passwords do not match!");
      }
      return;
    }

    // 키 이름을 Spring Boot의 엔티티 필드와 일치시킵니다.
    const dataToSend = {
      id: formData.username,
      pass: formData.password,
      name: formData.name,
      email: formData.email
    };

    axios.post('/saveReg', {id : 'hello', pass : 12341234, name: 'vince', email : 'tjdgns3728@naver.com'})
      .then(response => {
        alert('Registration successful!');
      })
      .catch(error => {
        console.error('There was an error saving the member!', error);
      });
  };

  return (
    <Container className="mt-5">
      <Row className="justify-content-md-center">
        <Col md={6}>
          <h2 className="text-center">회원가입</h2>
          <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <InputField
              id="username"
              label="아이디"
              type="text"
              value={formData.username}
              handleChange={handleChange}
              feedback="올바른 아이디를 입력하세요."
            />
            <InputField
              id="password"
              label="비밀번호"
              type="password"
              value={formData.password}
              handleChange={handleChange}
              feedback="최소 6자 이상의 비밀번호를 입력하세요."
            />
            <InputField
              id="confirmPassword"
              label="비밀번호 확인"
              type="password"
              value={formData.confirmPassword}
              handleChange={handleChange}
              feedback="비밀번호를 다시 확인하세요."
            />
            <InputField
              id="name"
              label="이름"
              type="text"
              value={formData.name}
              handleChange={handleChange}
              feedback="이름을 입력하세요."
            />
            <InputField
              id="email"
              label="이메일"
              type="email"
              value={formData.email}
              handleChange={handleChange}
              feedback="올바른 이메일 주소를 입력하세요."
            />
            <Button variant="primary" type="submit" className="w-100 mt-3">
              가입하기
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
}

export default App;