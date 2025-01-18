import React, { useState, useEffect } from "react";
import axios from "axios";
import "./index.css";

// Base API URL
const API_URL = "http://localhost:8080";

function App() {
  const [students, setStudents] = useState([]);
  const [newStudent, setNewStudent] = useState({
    name: "",
    percentage: "",
    branch: "",
  });
  const [loading, setLoading] = useState(false);

  // Fetch all students on component mount
  useEffect(() => {
    setLoading(true);
    axios
      .get(`${API_URL}/students`)
      .then((response) => {
        setStudents(response.data);
      })
      .catch((error) => {
        console.error("Error fetching students", error);
      })
      .finally(() => setLoading(false));
  }, []);

  // Handle input changes for new student form
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({ ...newStudent, [name]: value });
  };

  // Handle adding a new student
  const addStudent = (e) => {
    e.preventDefault();
    if (!newStudent.name || !newStudent.percentage || !newStudent.branch) {
      alert("All fields are required");
      return;
    }
    setLoading(true);
    axios
      .post(`${API_URL}/students/add`, newStudent)
      .then((response) => {
        setStudents([...students, response.data]);
        setNewStudent({ name: "", percentage: "", branch: "" });
      })
      .catch((error) => {
        console.error("Error adding student", error);
      })
      .finally(() => setLoading(false));
  };

  return (
    <div className="App">
      <header>
        <h1>Student Management System</h1>
      </header>

      <main>
        {/* Add New Student Form */}
        <div className="add-student-form">
          <h2>Add New Student</h2>
          <form onSubmit={addStudent}>
            <input
              type="text"
              name="name"
              value={newStudent.name}
              onChange={handleInputChange}
              placeholder="Student Name"
              required
            />
            <input
              type="number"
              name="percentage"
              value={newStudent.percentage}
              onChange={handleInputChange}
              placeholder="Percentage"
              required
            />
            <input
              type="text"
              name="branch"
              value={newStudent.branch}
              onChange={handleInputChange}
              placeholder="Branch"
              required
            />
            <button type="submit">Add Student</button>
          </form>
        </div>

        {/* Loading Indicator */}
        {loading && <p className="loading-text">Loading...</p>}

        {/* Student List */}
        <div className="student-list">
          <h2>Student List</h2>
          <div className="student-grid">
            {students.length > 0 ? (
              students.map((student) => (
                <div key={student.rollNo} className="student-card">
                  <h3>{student.name}</h3>
                  <p>
                    <strong>Percentage:</strong> {student.percentage}%
                  </p>
                  <p>
                    <strong>Branch:</strong> {student.branch}
                  </p>
                </div>
              ))
            ) : (
              <p>No students found</p>
            )}
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;
