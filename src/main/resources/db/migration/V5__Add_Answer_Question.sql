create table question_answer (
testing_id int8 not null references test_result,
test_result_id int8 not null references test_result
)
