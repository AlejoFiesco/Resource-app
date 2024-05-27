package com.example.demo.utilities.structures;

import com.example.demo.utilities.filters.Operators;
import com.example.demo.utilities.filters.ReserveFilter;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;

public class FilterUtils {
	public static Query createReserveQuery(CollectionReference collRef, ReserveFilter filters) {
		Query query = null;
		if (filters.getStartDate() != null) {
			query = collRef.whereGreaterThanOrEqualTo("to", filters.getStartDate());
//			if(filters.getEndDate() == null) filters.setEndDate(DateUtils.getCurrentDate());
			query = query.whereLessThanOrEqualTo("to", filters.getEndDate());

		}
		return query;
	}

	public static Query filterEqualTo(Query query, String entry, Object value) {
		return query.whereEqualTo(entry, value);
	}

	public static Query filterByRange(Query query, String entry, Object value, Operators operator) {
		return operator.equals(Operators.GREATER) 
				? query.whereGreaterThanOrEqualTo(entry, value)
				: query.whereLessThanOrEqualTo(entry, value);
	}
}
