import React, { useState, useEffect } from "react";
import { getQuizzes } from "../services/QuizService";

const ListQuizes = () => {
  const [quizzes, setQuizzes] = useState([]);

  useEffect(() => {
    const fetchQuizzes = async () => {
      try {
        const data = await getQuizzes();
        setQuizzes(data);
      } catch (error) {
        // Handle error, e.g., show an error message to the user
        console.error('Error fetching quizzes:', error);
      }
    };

    fetchQuizzes();
  }, []);

  return (
    <div className="container mx-auto p-4 ">
      <h1 className="text-center text-2xl font-bold mb-4">Quiz List</h1>
      <div className='flex justify-center'>
      <table className="min-w-full border rounded overflow-hidden"> 
        <thead className="bg-gray-800 text-white"> 
          <tr>
            <th className="py-2 px-4">ID</th>
            <td className="py-2 px-4 font-bold">Title</td>
            <td className="py-2 px-4 font-bold">Category</td>
            <th className="py-2 px-4">Action</th>
          </tr>
        </thead>
        <tbody className="mt-4">
          {quizzes.map((quiz) => (
            <tr key={quiz.id}>
              <th>{quiz.id}</th>
              <td className="py-2 px-4 font-bold">{quiz.title}</td>
              <td className="py-2 px-4 font-bold">{quiz.category}</td>
              <th>
                <a href={`/view-questions/${quiz.id}`}>Click here to View Questions</a>
              </th>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
    </div>
  );
};

export default ListQuizes;