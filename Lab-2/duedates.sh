cat << EOM
Choose the due date
(L1) Lab 1: 09/28/2022
(L2) Lab 2: 10/26/2022
(L3) Lab 3: 11/23/2022
(L4) Lab 4: 12/7/2022
Quizes
(Q1) Quiz 1: 09/14/2022
(Q2) Quiz 2: 09/28/2022
(Q3) Quiz 3: 10/26/2022
(Q4) Quiz 4: 11/16/2022
(Q5) Quiz 5: 12/07/2022
(F) Final: 12/19/2022
EOM

read

while ! [[ $REPLY =~ (L[1-4])|(Q[1-5])|(F) ]]
do
     echo Not a valid input, please try again
     read
done

current_date=$(date +%s)

    if [ $REPLY == "L1" ]
    then
        end_date=$(date -j -f "%m/%d/%Y" "09/28/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
        
    elif [ $REPLY == "L2" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "10/26/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days

    elif [ $REPLY == "L3" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "11/23/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "L4" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "12/7/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "Q1" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "09/14/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "Q2" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "09/28/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "Q3" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "10/26/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "Q4" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "11/16/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "Q5" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "12/07/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    elif [ $REPLY == "F" ] 
    then
        end_date=$(date -j -f "%m/%d/%Y" "12/19/2022" "+%s")
        echo $(( ($end_date - $current_date) / (60 * 60 * 24) )) days
    fi
